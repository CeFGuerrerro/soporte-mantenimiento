/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.facades.ResponsablesFacadeLocal;
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
@Named(value = "responsablesMB")
@SessionScoped
public class ResponsablesMB implements Serializable {

    @EJB
    private ResponsablesFacadeLocal responsablesFacade;

    private Responsables resp;
    private Responsables respSeleccionado;
    private List<Responsables> respList = new ArrayList<>();
    
    public ResponsablesMB() {
    }
    
    @PostConstruct
    public void init(){
        obtenerTodos();
        resp = new Responsables();
        respSeleccionado = new Responsables();
    }

    public Responsables getResp() {
        return resp;
    }

    public void setResp(Responsables resp) {
        this.resp = resp;
    }

    public Responsables getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(Responsables respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    public List<Responsables> getRespList() {
        return respList;
    }

    public void setRespList(List<Responsables> respList) {
        this.respList = respList;
    }
    
    public void obtenerTodos(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            respList = responsablesFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void crearResponsable(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean creado = responsablesFacade.create(resp);
            if (creado) {
                resp = new Responsables();
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void editarResponsable(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean modificado = responsablesFacade.edit(respSeleccionado);
            if (modificado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
     public void eliminarResponsable(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean eliminado = responsablesFacade.remove(respSeleccionado);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
}
