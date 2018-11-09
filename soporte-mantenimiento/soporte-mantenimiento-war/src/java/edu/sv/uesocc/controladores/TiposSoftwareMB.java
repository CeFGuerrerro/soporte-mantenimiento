/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.TiposSoftware;
import edu.sv.uesocc.facades.TiposSoftwareFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/** 
 *
 * @author o-a19
 */
@Named(value = "tiposSoftwareMB")
@SessionScoped
public class TiposSoftwareMB implements Serializable {

    @EJB
    private TiposSoftwareFacadeLocal tiposSoftwareFacade;

    // Declaracion de entidades 
    private TiposSoftware tiposSW;
    private TiposSoftware tipoSWSeleccionado;
    private List<TiposSoftware> tipoSWList = new ArrayList<>();

    /**
     * Creates a new instance of TiposSoftwareMB
     */
    public TiposSoftwareMB() {
    }

    @PostConstruct
    private void init() {
        tiposSW = new TiposSoftware();
        tipoSWSeleccionado = new TiposSoftware();
        obtenerTodos();
    }

    // Getters y setters

    public TiposSoftwareFacadeLocal getTiposSoftwareFacade() {
        return tiposSoftwareFacade;
    }
    
     public void setTiposSoftwareFacade(TiposSoftwareFacadeLocal tiposSoftwareFacade) {
        this.tiposSoftwareFacade = tiposSoftwareFacade;
    }

    public TiposSoftware getTiposSW() {
        return tiposSW;
    }
     public void setTiposSW(TiposSoftware tiposSW) {
        this.tiposSW = tiposSW;
    }

    public TiposSoftware getTipoSWSeleccionado() {
        return tipoSWSeleccionado;
    }
      public void setTipoSWSeleccionado(TiposSoftware tipoSWSeleccionado) {
        this.tipoSWSeleccionado = tipoSWSeleccionado;
    }

    public List<TiposSoftware> getTipoSWList() {
        return tipoSWList;
    }

    public void setTipoSWList(List<TiposSoftware> tipoSWList) {
        this.tipoSWList = tipoSWList;
    }

    // --------------- Metodos ---------------------- 
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tipoSWList = tiposSoftwareFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void crearTiposSoftware() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = tiposSoftwareFacade.create(tiposSW);
            if (creado) {
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
                tiposSW = new TiposSoftware();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarTiposSoftware() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = tiposSoftwareFacade.remove(tipoSWSeleccionado);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void modificarTiposSoftware() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean modificado = false;
        try {
            modificado = tiposSoftwareFacade.edit(tipoSWSeleccionado);
            if (modificado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

}
