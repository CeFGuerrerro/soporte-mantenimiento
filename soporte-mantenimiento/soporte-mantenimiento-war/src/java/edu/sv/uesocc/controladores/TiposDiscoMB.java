/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.TiposDisco;
import edu.sv.uesocc.facades.TiposDiscoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author o-a19
 */
@Named(value = "tiposDiscoMB")
@ViewScoped
public class TiposDiscoMB implements Serializable {

    @EJB
    private TiposDiscoFacadeLocal tiposDiscoFacade;

    private TiposDisco tipoDisco;
    private TiposDisco tipoDiscoSeleccionado;
    private List<TiposDisco> tipoDiscoList = new ArrayList<>();
    FacesContext contexto = FacesContext.getCurrentInstance();

    public TiposDiscoMB() {
    }

    public void init() {
        tipoDisco = new TiposDisco();
        tipoDiscoSeleccionado = new TiposDisco();
        obtenerTodos();
    }

    public TiposDisco getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(TiposDisco tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public TiposDisco getTipoDiscoSeleccionado() {
        return tipoDiscoSeleccionado;
    }

    public void setTipoDiscoSeleccionado(TiposDisco tipoDiscoSeleccionado) {
        this.tipoDiscoSeleccionado = tipoDiscoSeleccionado;
    }

    public List<TiposDisco> getTipoDiscoList() {
        return tipoDiscoList;
    }

    public void setTipoDiscoList(List<TiposDisco> tipoDiscoList) {
        this.tipoDiscoList = tipoDiscoList;
    }

    public void obtenerTodos() {
        try {
            tipoDiscoList = tiposDiscoFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarTipoDisco() {
        try {
            boolean creado = false;
            if (creado) {
                tipoDisco = new TiposDisco();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarTipoDisco() {
        boolean eliminado = false;
        try {
            eliminado = tiposDiscoFacade.remove(tipoDisco);
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

    public void editarTipoDisco() {
        boolean editado = false;
        try {
            editado = tiposDiscoFacade.edit(tipoDisco);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningun cambio fue efectuado en registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

}
