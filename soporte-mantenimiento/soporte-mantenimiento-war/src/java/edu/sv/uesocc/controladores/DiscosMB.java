/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Discos;
import edu.sv.uesocc.facades.DiscosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author o-a19
 */
@Named(value = "discosMB")
@SessionScoped
public class DiscosMB implements Serializable {

    @EJB
    private DiscosFacadeLocal discosFacade;
    
    private Discos disco;
    private Discos discosSeleccionados;
    private List<Discos> discosList= new ArrayList<>();
    
    public DiscosMB() {
    }
    private void init() {
        disco = new Discos();
        discosSeleccionados = new Discos();
        obtenerTodos();
    }

    public Discos getDisco() {
        return disco;
    }

    public void setDisco(Discos disco) {
        this.disco = disco;
    }

    public Discos getDiscosSeleccionados() {
        return discosSeleccionados;
    }

    public void setDiscosSeleccionados(Discos discosSeleccionados) {
        this.discosSeleccionados = discosSeleccionados;
    }

    
    public List<Discos> getDiscosList() {
        return discosList;
    }

    public void setDiscosList(List<Discos> discosList) {
        this.discosList = discosList;
    }

    
    public void obtenerTodos()
    {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            discosList = discosFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
        
    }
    public void agregarDisco()
    {
        boolean agregado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           agregado = discosFacade.create(disco);
           if(agregado){
               disco = new Discos();
               contexto.addMessage(null, new FacesMessage("Registro guardado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    public void eliminarDisco()
    {
        boolean eliminado= false;
        FacesContext contexto= FacesContext.getCurrentInstance();
        try {
            eliminado= discosFacade.remove(disco);
            if (eliminado) {
                 contexto.addMessage(null, new FacesMessage("Disco eliminado"));
            }
            else{
            contexto.addMessage(null, new FacesMessage("No se ha podido eliminar el disco seleccionado"));
        }obtenerTodos(); 
        }catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
        
    }
    public void editarDisco()
    {
        boolean editado =false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado=discosFacade.edit(disco);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Disco modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningun cambio fue efectuado en el disco seleccionado"));
            }obtenerTodos();;
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error!", e.getMessage()));
        }
    }
    
    
}
