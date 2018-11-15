
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Modelos;
import edu.sv.uesocc.facades.ModelosFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


@Named(value = "modelosMB")
@ViewScoped
public class ModelosMB implements Serializable {

    @EJB
    private ModelosFacadeLocal modelf;
    
    private Modelos model;
    private Modelos modelSeleccionado;
    private List<Modelos> modelList = new ArrayList<>();

    public ModelosMB() {
    }
    
    @PostConstruct
    private void init(){
        model = new Modelos();
        modelSeleccionado = new Modelos();
        obtenerTodos();
    }

    public Modelos getModel() {
        return model;
    }

    public void setModel(Modelos model) {
        this.model = model;
    }

    public Modelos getModelSeleccionado() {
        return modelSeleccionado;
    }

    public void setModelSeleccionado(Modelos modelSeleccionado) {
        this.modelSeleccionado = modelSeleccionado;
    }

    public List<Modelos> getModelList() {
        return modelList;
    }

    public void setModelList(List<Modelos> modelList) {
        this.modelList = modelList;
    }
    
    
    public void obtenerTodos(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            modelList = modelf.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void crearModelo() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           creado = modelf.create(model);
           if(creado){
               model = new Modelos();
               contexto.addMessage(null, new FacesMessage("Registro guardado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void eliminarModelo() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           eliminado = modelf.remove(modelSeleccionado);
           if(eliminado){
               contexto.addMessage(null, new FacesMessage("Registro eliminado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void modificarModelo() {
        boolean modificado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           modificado = modelf.edit(modelSeleccionado);
           if(modificado){
               contexto.addMessage(null, new FacesMessage("Registro modificado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
}
