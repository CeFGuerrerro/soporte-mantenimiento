package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Mantenimientos;
import edu.sv.uesocc.facades.MantenimientosFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "mantenimientosMB")
@ViewScoped
public class MantenimientosMB implements Serializable {

    public MantenimientosMB() {
    }
    
    @EJB
    private MantenimientosFacadeLocal mantenimientoEJB;
    private List<Mantenimientos> mantenimientos;
    private Mantenimientos mantenimiento;
    private Mantenimientos seleccion;

    public List<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Mantenimientos getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimientos mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Mantenimientos getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Mantenimientos seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        mantenimiento = new Mantenimientos();
        seleccion = new Mantenimientos();
        mantenimientos = mantenimientoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = mantenimientoEJB.create(mantenimiento);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        mantenimientos = mantenimientoEJB.findAll();
        mantenimiento = new Mantenimientos();
    }
    
    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = mantenimientoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        mantenimientos = mantenimientoEJB.findAll();
        seleccion = new Mantenimientos();
    }
    
}
