/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Discos;
import edu.sv.uesocc.facades.DiscosFacadeLocal;
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
@Named(value = "discosMB")
@ViewScoped
public class DiscosMB implements Serializable {

    @EJB
    private DiscosFacadeLocal discosFacade;
    
    private Discos disco;
    private Discos discosSeleccionados;
    private List<Discos> discosList= new ArrayList<>();
    
    public DiscosMB() {
    }
    @PostConstruct
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
            disco.setEstado(true);
            disco.setAsignado(false);
           agregado = discosFacade.create(disco);
           if(agregado){
              // disco = new Discos();
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
            eliminado= discosFacade.remove(discosSeleccionados);
            if (eliminado) {
                 contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            }
            else{
            contexto.addMessage(null, new FacesMessage("No se ha podido eliminar el registro seleccionado"));
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
            editado=discosFacade.edit(discosSeleccionados);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningún cambio fue efectuado en el registro seleccionado"));
            }obtenerTodos();;
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error!", e.getMessage()));
        }
    }
    
    
}
