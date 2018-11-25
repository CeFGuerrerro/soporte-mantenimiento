/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Puertos;
import edu.sv.uesocc.facades.PuertosFacadeLocal;
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
@Named(value = "puertosMB")
@ViewScoped
public class PuertosMB implements Serializable {

    @EJB
    private PuertosFacadeLocal puertosFacade;

    private Puertos puerto;
    private Puertos puertoSeleccionado;
    private List<Puertos> puertoList = new ArrayList<>();
     
    public PuertosMB() {
    }
    @PostConstruct
    public void init(){
    puerto = new Puertos();
    puertoSeleccionado = new Puertos();
    obtenerTodos();
    }

    public Puertos getPuerto() {
        return puerto;
    }

    public void setPuerto(Puertos puerto) {
        this.puerto = puerto;
    }

    public Puertos getPuertoSeleccionado() {
        return puertoSeleccionado;
    }

    public void setPuertoSeleccionado(Puertos puertoSeleccionado) {
        this.puertoSeleccionado = puertoSeleccionado;
    }

    public List<Puertos> getPuertoList() {
        return puertoList;
    }

    public void setPuertoList(List<Puertos> puertoList) {
        this.puertoList = puertoList;
    }
 
    private void obtenerTodos() {
        
    FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            puertoList = puertosFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarPuerto()
    {
        
    FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado=puertosFacade.create(puerto);
            if (creado) {
                puerto = new Puertos();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarPuerto() {
        
    FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = puertosFacade.remove(puerto);
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

    public void editarPuerto() {
        
    FacesContext contexto = FacesContext.getCurrentInstance();
        boolean editado = false;
        try {
            editado = puertosFacade.edit(puertoSeleccionado);
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
