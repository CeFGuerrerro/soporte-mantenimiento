package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.TiposComponente;
import edu.sv.uesocc.facades.TiposComponenteFacadeLocal;
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
@Named(value = "tiposComponenteMB") // Con este nombre se llama el controlador en la pagina web
@ViewScoped
public class TiposComponenteMB implements Serializable {

    //EJB inyectado
    @EJB
    private TiposComponenteFacadeLocal tcf;

    // Declaracion de entidades 
    private TiposComponente tipoComp;
    private TiposComponente tipoCompSeleccionado;
    private List<TiposComponente> tipoCompList = new ArrayList<>();

    // Constructor de la clase, ya viene por defecto
    public TiposComponenteMB() {
    }

    //Metodo que se ejecuta cuando se carga la pagina web
    @PostConstruct
    private void init() {
        tipoComp = new TiposComponente();
        tipoCompSeleccionado = new TiposComponente();
        obtenerTodos();
    }

    // Getters y setters
    public TiposComponente getTipoComp() {
        return tipoComp;
    }

    public void setTipoComp(TiposComponente tipoComp) {
        this.tipoComp = tipoComp;
    }

    public TiposComponente getTipoCompSeleccionado() {
        return tipoCompSeleccionado;
    }

    public void setTipoCompSeleccionado(TiposComponente tipoCompSeleccionado) {
        this.tipoCompSeleccionado = tipoCompSeleccionado;
    }

    public List<TiposComponente> getTipoCompList() {
        return tipoCompList;
    }

    public void setTipoCompList(List<TiposComponente> tipoCompList) {
        this.tipoCompList = tipoCompList;
    }

    // Metodos publicos para el funcionamiento
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tipoCompList = tcf.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void crearTipoComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = tcf.create(tipoComp);
            if (creado) {
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
                tipoComp = new TiposComponente();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarTipoComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = tcf.remove(tipoCompSeleccionado);
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

    public void modificarTipoComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean modificado = false;
        try {
            modificado = tcf.edit(tipoCompSeleccionado);
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
