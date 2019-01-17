/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Velocidad;
import edu.sv.uesocc.facades.VelocidadFacadeLocal;
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
 * @author Gaby
 */
@Named(value = "velocidadMB")
@ViewScoped
public class VelocidadMB implements Serializable {

    @EJB
    private VelocidadFacadeLocal speedFacade;

    private Velocidad speed;
    private Velocidad speedSeleccionado;
    private List<Velocidad> speedList = new ArrayList<>();

    public VelocidadMB() {
    }

    @PostConstruct
    public void init() {
        speed = new Velocidad();
        speedSeleccionado = new Velocidad();
        obtenerTodos();
    }

    public Velocidad getSpeed() {
        return speed;
    }

    public void setSpeed(Velocidad speed) {
        this.speed = speed;
    }

    public Velocidad getSpeedSeleccionado() {
        return speedSeleccionado;
    }

    public void setSpeedSeleccionado(Velocidad speedSeleccionado) {
        this.speedSeleccionado = speedSeleccionado;
    }

    public List<Velocidad> getSpeedList() {
        return speedList;
    }

    public void setSpeedList(List<Velocidad> speedList) {
        this.speedList = speedList;
    }

   
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            speedList = speedFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarVelocidad() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado=speedFacade.create(speed);
            if (creado) {
                speed = new Velocidad();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarVelocidad() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = speedFacade.remove(speedSeleccionado);
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

    public void editarVelocidad() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = speedFacade.edit(speedSeleccionado);
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

