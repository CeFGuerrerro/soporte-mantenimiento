package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Soluciones;
import edu.sv.uesocc.facades.SolucionesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "solucionesMB")
@SessionScoped
public class SolucionesMB implements Serializable {

    public SolucionesMB() {
    }
    
    @EJB
    private SolucionesFacadeLocal solucionEJB;
    private List<Soluciones> soluciones;
    private Soluciones solucion;
    private Soluciones seleccion;

    public List<Soluciones> getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(List<Soluciones> soluciones) {
        this.soluciones = soluciones;
    }

    public Soluciones getSolucion() {
        return solucion;
    }

    public void setSolucion(Soluciones solucion) {
        this.solucion = solucion;
    }

    public Soluciones getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Soluciones seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        solucion = new Soluciones();
        seleccion = new Soluciones();
        soluciones = solucionEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = solucionEJB.create(solucion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        soluciones = solucionEJB.findAll();
        solucion = null;
    }
    
    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = solucionEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        soluciones = solucionEJB.findAll();
        seleccion = null;
    }
}
