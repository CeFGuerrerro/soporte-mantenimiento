package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.EstadosSolicitud;
import edu.sv.uesocc.facades.EstadosSolicitudFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "estadosSolicitudMB")
@SessionScoped
public class EstadosSolicitudMB implements Serializable {

    public EstadosSolicitudMB() {
    }
    
    @EJB
    private EstadosSolicitudFacadeLocal estadoEJB;
    private List<EstadosSolicitud> estados;
    private EstadosSolicitud estado;
    private EstadosSolicitud seleccion;

    public List<EstadosSolicitud> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadosSolicitud> estados) {
        this.estados = estados;
    }

    public EstadosSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadosSolicitud estado) {
        this.estado = estado;
    }

    public EstadosSolicitud getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(EstadosSolicitud seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        estado = new EstadosSolicitud();
        seleccion = new EstadosSolicitud();
        estados = estadoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = estadoEJB.create(estado);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
                estado = new EstadosSolicitud();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        estados = estadoEJB.findAll();
    }

    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = estadoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                seleccion = new EstadosSolicitud();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        estados = estadoEJB.findAll();
    }

    public void eliminar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = estadoEJB.remove(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado."));
                seleccion = new EstadosSolicitud();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        estados = estadoEJB.findAll();
    }
}
