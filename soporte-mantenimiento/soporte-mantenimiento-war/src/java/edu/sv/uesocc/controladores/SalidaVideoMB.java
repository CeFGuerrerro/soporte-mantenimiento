/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.SalidaVideo;
import edu.sv.uesocc.facades.SalidaVideoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gaby
 */
@Named(value = "salidaVideoMB")
@ViewScoped
public class SalidaVideoMB implements Serializable{
@EJB
    private SalidaVideoFacadeLocal salidaFacade;

    private SalidaVideo salida;
    private SalidaVideo salidaSeleccionada;
    private List<SalidaVideo> salidaList = new ArrayList<>();

    public SalidaVideoMB() {
    }

    @PostConstruct
    public void init() {
        salida = new SalidaVideo();
        salidaSeleccionada = new SalidaVideo();
        obtenerTodos();
    }

    public SalidaVideo getSalida() {
        return salida;
    }

    public void setSalida(SalidaVideo salida) {
        this.salida = salida;
    }

    public SalidaVideo getSalidaSeleccionada() {
        return salidaSeleccionada;
    }

    public void setSalidaSeleccionada(SalidaVideo salidaSeleccionada) {
        this.salidaSeleccionada = salidaSeleccionada;
    }

    public List<SalidaVideo> getSalidaList() {
        return salidaList;
    }

    public void setSalidaList(List<SalidaVideo> salidaList) {
        this.salidaList = salidaList;
    }
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            salidaList = salidaFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarSalidaVideo() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado=salidaFacade.create(salida);
            if (creado) {
                salida = new SalidaVideo();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarSalidaVideo() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = salidaFacade.remove(salidaSeleccionada);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se ha podido eliminar registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void editarSalidaVideo() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = salidaFacade.edit(salidaSeleccionada);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningún cambio fue efectuado en registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
}
