/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Fuentes;
import edu.sv.uesocc.facades.FuentesFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author o-a19
 */
@Named(value = "fuentesMB")
@ViewScoped
public class FuentesMB implements Serializable {

    @EJB
    private FuentesFacadeLocal fuentesFacade;

    private Fuentes fuente;
    private Fuentes fuenteSeleccionada;
    private List<Fuentes> fuenteList = new ArrayList<>();

    public FuentesMB() {
    }

    @PostConstruct
    public void init() {
        fuente = new Fuentes();
        fuenteSeleccionada = new Fuentes();
        obtenerTodos();
    }

    public Fuentes getFuente() {
        return fuente;
    }

    public void setFuente(Fuentes fuente) {
        this.fuente = fuente;
    }

    public Fuentes getFuenteSeleccionada() {
        return fuenteSeleccionada;
    }

    public void setFuenteSeleccionada(Fuentes fuenteSeleccionada) {
        this.fuenteSeleccionada = fuenteSeleccionada;
    }

    public List<Fuentes> getFuenteList() {
        return fuenteList;
    }

    public void setFuenteList(List<Fuentes> fuenteList) {
        this.fuenteList = fuenteList;
    }

    private void obtenerTodos() {

        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            fuenteList = fuentesFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarFuente() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado = fuentesFacade.create(fuente);
            if (creado) {
                fuente = new Fuentes();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarFuente() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = fuentesFacade.remove(fuenteSeleccionada);
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

    public void editarFuente() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = fuentesFacade.edit(fuenteSeleccionada);
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
