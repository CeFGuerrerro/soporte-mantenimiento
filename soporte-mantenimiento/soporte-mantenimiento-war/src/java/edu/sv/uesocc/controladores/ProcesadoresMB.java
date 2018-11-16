/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Procesadores;
import edu.sv.uesocc.facades.ProcesadoresFacadeLocal;
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
@Named(value = "procesadoresMB")
@ViewScoped
public class ProcesadoresMB implements Serializable {

    @EJB
    private ProcesadoresFacadeLocal procesadoresFacade;
    private Procesadores procesador;
    private Procesadores procesadorSeleccionado;
    private List<Procesadores> procesadorList = new ArrayList<>();
    FacesContext contexto = FacesContext.getCurrentInstance();

    public ProcesadoresMB() {
    }
    
    public void init(){
    procesador = new Procesadores();
    procesadorSeleccionado = new Procesadores();
    obtenerTodos();
    }

    public Procesadores getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesadores procesador) {
        this.procesador = procesador;
    }

    public Procesadores getProcesadorSeleccionado() {
        return procesadorSeleccionado;
    }

    public void setProcesadorSeleccionado(Procesadores procesadorSeleccionado) {
        this.procesadorSeleccionado = procesadorSeleccionado;
    }

    public List<Procesadores> getProcesadorList() {
        return procesadorList;
    }

    public void setProcesadorList(List<Procesadores> procesadorList) {
        this.procesadorList = procesadorList;
    }

    private void obtenerTodos() {
        try {
            procesadorList = procesadoresFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarProcesador() {
        try {
            boolean creado = false;
            if (creado) {
                procesador = new Procesadores();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarProcesador() {
        boolean eliminado = false;
        try {
            eliminado = procesadoresFacade.remove(procesador);
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

    public void editarProcesador() {
        boolean editado = false;
        try {
            editado = procesadoresFacade.edit(procesador);
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
