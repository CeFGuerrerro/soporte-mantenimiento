package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.EquiposAsignados;
import edu.sv.uesocc.entidades.Resposables;
import edu.sv.uesocc.facades.EquiposAsignadosFacadeLocal;
import edu.sv.uesocc.facades.EquiposFacadeLocal;
import edu.sv.uesocc.facades.ResposablesFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "equiposAsignadosMB")
@ViewScoped
public class EquiposAsignadosMB implements Serializable {

    public EquiposAsignadosMB() {
    }
    
    @EJB
    private EquiposAsignadosFacadeLocal equiposasignadosEJB;
    @EJB
    private EquiposFacadeLocal equiposEJB;
    @EJB
    private ResposablesFacadeLocal responsablesEJB;
    private EquiposAsignados equipoasignado;
    private List<EquiposAsignados> equiposasignados;
    private List<Resposables> responsables;
    private List<Equipos> equipos;
    private EquiposAsignados seleccion;

    public EquiposAsignados getEquipoasignado() {
        return equipoasignado;
    }

    public void setEquipoasignado(EquiposAsignados equipoasignado) {
        this.equipoasignado = equipoasignado;
    }

    public List<EquiposAsignados> getEquiposasignados() {
        return equiposasignados;
    }

    public void setEquiposasignados(List<EquiposAsignados> equiposasignados) {
        this.equiposasignados = equiposasignados;
    }

    public List<Resposables> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Resposables> responsables) {
        this.responsables = responsables;
    }

    public List<Equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipos> equipos) {
        this.equipos = equipos;
    }

    public EquiposAsignados getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(EquiposAsignados seleccion) {
        this.seleccion = seleccion;
    }
    
    @PostConstruct
    public void init(){
        equipoasignado = new EquiposAsignados();
        seleccion = new EquiposAsignados();
        equiposasignados = equiposasignadosEJB.findAll();
        equipos =  equiposEJB.findAll();
        responsables = responsablesEJB.findAll();
    }
    
    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = equiposasignadosEJB.create(equipoasignado);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
                equipoasignado = new EquiposAsignados();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        equiposasignados = equiposasignadosEJB.findAll();
    }

    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = equiposasignadosEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                seleccion = new EquiposAsignados();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        equiposasignados = equiposasignadosEJB.findAll();
    }

    public void eliminar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = equiposasignadosEJB.remove(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado."));
                seleccion = new EquiposAsignados();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        equiposasignados = equiposasignadosEJB.findAll();
    }
}
