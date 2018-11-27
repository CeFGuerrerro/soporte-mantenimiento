
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Arquitecturas;
import edu.sv.uesocc.facades.ArquitecturasFacadeLocal;
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
@Named(value = "arquitecturasMB")
@ViewScoped
public class ArquitecturasMB implements Serializable {

    @EJB
    private ArquitecturasFacadeLocal arquitecturasFacade;

    // Declaracion de entidades 
    private Arquitecturas arqui;
    private Arquitecturas arquiSeleccionado;
    private List<Arquitecturas> arquiList = new ArrayList<>();
    
    /**
     * Creates a new instance of ArquitecturaMB
     */
    public ArquitecturasMB() {
    }
    
    @PostConstruct
    private void init() {
        arqui = new Arquitecturas();
        arquiSeleccionado = new Arquitecturas();
        obtenerTodos();
    }
    // Getters y setters
    public Arquitecturas getArquitecturas() {
        return arqui;
    }
    public void setArquitecturas(Arquitecturas arqui) {
        this.arqui = arqui;
    }
    public Arquitecturas getArquiSeleccionado() {
        return arquiSeleccionado;
    }
    public void setArquiSeleccionado(Arquitecturas arquiSeleccionado) {
        this.arquiSeleccionado = arquiSeleccionado;
    }
     public List<Arquitecturas> getArquiList() {
        return arquiList;
    }
      public void setArquiList(List<Arquitecturas> arquiList) {
        this.arquiList = arquiList;
    }
       // --------------- Metodos ---------------------- 
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            arquiList = arquitecturasFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void crearArquitecturas() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = arquitecturasFacade.create(arqui);
            if (creado) {
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
                arqui = new Arquitecturas();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
     public void eliminarArquitecturas() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = arquitecturasFacade.remove(arquiSeleccionado);
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
     public void modificarArquitecturas() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean modificado = false;
        try {
            modificado = arquitecturasFacade.edit(arquiSeleccionado);
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
