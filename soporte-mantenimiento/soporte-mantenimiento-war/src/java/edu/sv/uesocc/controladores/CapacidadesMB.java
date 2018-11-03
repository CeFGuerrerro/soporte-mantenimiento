package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Capacidades;
import edu.sv.uesocc.facades.CapacidadesFacadeLocal;
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
@Named(value = "capacidadesMB")
@SessionScoped
public class CapacidadesMB implements Serializable {

    @EJB
    private CapacidadesFacadeLocal capacidadesFacade;

    private Capacidades capacidad;
    private Capacidades objSeleccionado;
    private List<Capacidades> capacidadList = new ArrayList<>();

    public CapacidadesMB() {
    }

    public void init() {
        capacidad = new Capacidades();
        objSeleccionado = new Capacidades();
        obtenerTodas();
    }

    public Capacidades getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Capacidades capacidad) {
        this.capacidad = capacidad;
    }

    public Capacidades getObjSeleccionado() {
        return objSeleccionado;
    }

    public void setObjSeleccionado(Capacidades objSeleccionado) {
        this.objSeleccionado = objSeleccionado;
    }

    public List<Capacidades> getCapacidadList() {
        return capacidadList;
    }

    public void setCapacidadList(List<Capacidades> capacidadList) {
        this.capacidadList = capacidadList;
    }

    public void obtenerTodas() {

        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            capacidadList = capacidadesFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void agregarCapacidad() {
        boolean agregado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            agregado = capacidadesFacade.create(capacidad);
            if (agregado) {
                capacidad = new Capacidades();
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarCapacidad() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = capacidadesFacade.remove(capacidad);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se ha podido eliminar el registro seleccionado"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void editarCapacidad() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = capacidadesFacade.edit(capacidad);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningun cambio fue efectuado en registro seleccionado"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

}
