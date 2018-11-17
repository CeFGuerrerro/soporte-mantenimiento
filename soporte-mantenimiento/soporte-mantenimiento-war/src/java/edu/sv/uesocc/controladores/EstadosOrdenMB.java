package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.EstadosOrden;
import edu.sv.uesocc.facades.EstadosOrdenFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "estadosOrdenMB")
@SessionScoped
public class EstadosOrdenMB implements Serializable {

    public EstadosOrdenMB() {
    }

    @EJB
    private EstadosOrdenFacadeLocal estadoEJB;
    private List<EstadosOrden> estados;
    private EstadosOrden estado;
    private EstadosOrden seleccion;

    public List<EstadosOrden> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadosOrden> estados) {
        this.estados = estados;
    }

    public EstadosOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadosOrden estado) {
        this.estado = estado;
    }

    public EstadosOrden getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(EstadosOrden seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        estado = new EstadosOrden();
        seleccion = new EstadosOrden();
        estados = estadoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = estadoEJB.create(estado);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
                estado = new EstadosOrden();
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
                seleccion = new EstadosOrden();
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
                seleccion = new EstadosOrden();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        estados = estadoEJB.findAll();
    }
}
