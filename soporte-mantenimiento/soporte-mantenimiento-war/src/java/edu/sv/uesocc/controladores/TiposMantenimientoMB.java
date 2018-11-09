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
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author o-a19
 */
@Named(value = "tiposMantenimientoMB")
@SessionScoped
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
        tipoMantenimiento = new TiposMantenimiento();
        seleccion = new TiposMantenimiento();
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
        mantenimientos = mantenimientoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tipoMantenimientoEJB.create(tipoMantenimiento);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
        tipoMantenimiento = new TiposMantenimiento();
    }
    
    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tipoMantenimientoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
        seleccion = new TiposMantenimiento();
    }
    
    public void eliminar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tipoMantenimientoEJB.remove(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tiposMantenimiento = tipoMantenimientoEJB.findAll();
        seleccion = new TiposMantenimiento();
    }
}
