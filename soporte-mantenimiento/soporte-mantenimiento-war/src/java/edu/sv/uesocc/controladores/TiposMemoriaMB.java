/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.TiposMemoria;
import edu.sv.uesocc.facades.TiposMemoriaFacadeLocal;
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
@Named(value = "tiposMemoriaMB")
@ViewScoped
public class TiposMemoriaMB implements Serializable {

    @EJB
    private TiposMemoriaFacadeLocal tiposMemoriaFacade;
    private TiposMemoria tipoMemoria;
    private TiposMemoria tipoMemoriaSeleccionada;
    private List<TiposMemoria> tiposMemoriaList = new ArrayList<>();
    FacesContext contexto = FacesContext.getCurrentInstance();

    public TiposMemoriaMB() {
    }

    public void init() {
        tipoMemoria = new TiposMemoria();
        tipoMemoriaSeleccionada = new TiposMemoria();
        obtenerTodos();
    }

    public TiposMemoria getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(TiposMemoria tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public TiposMemoria getTipoMemoriaSeleccionada() {
        return tipoMemoriaSeleccionada;
    }

    public void setTipoMemoriaSeleccionada(TiposMemoria tipoMemoriaSeleccionada) {
        this.tipoMemoriaSeleccionada = tipoMemoriaSeleccionada;
    }

    public List<TiposMemoria> getTiposMemoriaList() {
        return tiposMemoriaList;
    }

    public void setTiposMemoriaList(List<TiposMemoria> tiposMemoriaList) {
        this.tiposMemoriaList = tiposMemoriaList;
    }

    public void obtenerTodos() {
        try {
            tiposMemoriaList = tiposMemoriaFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarTipoMemoria() {
        try {
            boolean creado = false;
            if (creado) {
                tipoMemoria = new TiposMemoria();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarTipoMemoria() {
        boolean eliminado = false;
        try {
            eliminado = tiposMemoriaFacade.remove(tipoMemoria);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Memoria eliminada"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se ha podido eliminar memoria seleccionada"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void editarTipoMemoria() {
        boolean editado = false;
        try {
            editado = tiposMemoriaFacade.edit(tipoMemoria);
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
