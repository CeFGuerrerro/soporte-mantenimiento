
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
import javax.annotation.PostConstruct;
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

    private TiposDisco tpDisco;
    private TiposDisco tipoDiscoSeleccionado;
    private List<TiposDisco> tipoDiscoList = new ArrayList<>();

    public TiposDiscoMB() {
    }

    @PostConstruct
    public void init() {
        tpDisco = new TiposDisco();
        tipoDiscoSeleccionado = new TiposDisco();
        obtenerTodos();
    }

    public TiposDisco getTipoDisco() {
        return tpDisco;
    }

    public void setTipoDisco(TiposDisco tpDisco) {
        this.tpDisco = tpDisco;
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
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tipoDiscoList = tiposDiscoFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarTipoDisco() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado=tiposDiscoFacade.create(tpDisco);
            if (creado) {
                tpDisco = new TiposDisco();
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
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = tiposDiscoFacade.remove(tpDisco);
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
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = tiposDiscoFacade.edit(tpDisco);
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
