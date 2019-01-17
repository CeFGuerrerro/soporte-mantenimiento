/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.SalidaTarjetaVideo;
import edu.sv.uesocc.facades.SalidaTarjetaVideoFacadeLocal;
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
@Named(value = "salidaTarjetaVideoMB")
@ViewScoped
public class SalidaTarjetaVideoMB implements Serializable {

    @EJB
    private SalidaTarjetaVideoFacadeLocal SalidaVCFacade;
    private SalidaTarjetaVideo salidaVC;
    private SalidaTarjetaVideo salidaVCSeleccionada;
    private List<SalidaTarjetaVideo> salidaVCList = new ArrayList<>();

    public SalidaTarjetaVideoMB() {
    }

    @PostConstruct
    public void init() {
        salidaVC = new SalidaTarjetaVideo();
        salidaVCSeleccionada = new SalidaTarjetaVideo();
        obtenerTodos();
    }

    public SalidaTarjetaVideo getSalidaVC() {
        return salidaVC;
    }

    public void setSalidaVC(SalidaTarjetaVideo salidaVC) {
        this.salidaVC = salidaVC;
    }

    public SalidaTarjetaVideo getSalidaVCSeleccionada() {
        return salidaVCSeleccionada;
    }

    public void setSalidaVCSeleccionada(SalidaTarjetaVideo salidaVCSeleccionada) {
        this.salidaVCSeleccionada = salidaVCSeleccionada;
    }

    public List<SalidaTarjetaVideo> getSalidaVCList() {
        return salidaVCList;
    }

    public void setSalidaVCList(List<SalidaTarjetaVideo> salidaVCList) {
        this.salidaVCList = salidaVCList;
    }
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            salidaVCList = SalidaVCFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarSalidaVC() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado=SalidaVCFacade.create(salidaVC);
            if (creado) {
                salidaVC = new SalidaTarjetaVideo();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarSalidaVC() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = SalidaVCFacade.remove(salidaVCSeleccionada);
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

    public void editarSalidaVC() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = SalidaVCFacade.edit(salidaVCSeleccionada);
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
