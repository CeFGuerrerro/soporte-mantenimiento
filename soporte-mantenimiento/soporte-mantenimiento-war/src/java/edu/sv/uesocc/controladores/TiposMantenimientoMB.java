/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Mantenimientos;
import edu.sv.uesocc.entidades.TiposMantenimiento;
import edu.sv.uesocc.facades.MantenimientosFacadeLocal;
import edu.sv.uesocc.facades.TiposMantenimientoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
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
@Named(value = "tiposMantenimientoMB")
@ViewScoped
public class TiposMantenimientoMB implements Serializable {

    /**
     * Creates a new instance of TiposMantenimientoMB
     */
    public TiposMantenimientoMB() {
    }

    @EJB
    private TiposMantenimientoFacadeLocal tipoMantenimientoEJB;
    private List<TiposMantenimiento> tiposMantenimiento;
    private TiposMantenimiento tipoMantenimiento;
    private TiposMantenimiento seleccion;
    @EJB
    private MantenimientosFacadeLocal mantenimientoEJB;
    private List<Mantenimientos> mantenimientos;
    private Mantenimientos mantenimiento;

    public Mantenimientos getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimientos mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public List<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public List<TiposMantenimiento> getTiposMantenimiento() {
        return tiposMantenimiento;
    }

    public void setTiposMantenimiento(List<TiposMantenimiento> tiposMantenimiento) {
        this.tiposMantenimiento = tiposMantenimiento;
    }

    public TiposMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(TiposMantenimiento tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public TiposMantenimiento getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(TiposMantenimiento seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        mantenimiento = new Mantenimientos();
        tipoMantenimiento = new TiposMantenimiento();
        seleccion = new TiposMantenimiento();
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
        mantenimientos = mantenimientoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tipoMantenimiento.setIdMantenimiento(mantenimiento);
            registrado = tipoMantenimientoEJB.create(tipoMantenimiento);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
                mantenimiento = new Mantenimientos();
                tipoMantenimiento = new TiposMantenimiento();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
    }

    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            seleccion.setIdMantenimiento(mantenimiento);
            registrado = tipoMantenimientoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                mantenimiento = new Mantenimientos();
                seleccion = new TiposMantenimiento();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
    }

    public void eliminar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tipoMantenimientoEJB.remove(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                seleccion = new TiposMantenimiento();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
    }
}
