/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.SoftwareComponente;
import edu.sv.uesocc.facades.SoftwareComponenteFacadeLocal;
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
@Named(value = "softwareComponenteMB")
@ViewScoped
public class SoftwareComponenteMB implements Serializable {

    @EJB
    private SoftwareComponenteFacadeLocal scfl;

    // Declaracion de entidades 
    private SoftwareComponente softComp;
    private SoftwareComponente softCompSelec;
    private List<SoftwareComponente> softCompList = new ArrayList<>();

    public SoftwareComponenteMB() {
    }

    @PostConstruct
    private void init() {
        softComp = new SoftwareComponente();
        softCompSelec = new SoftwareComponente();
        obtenerTodos();
    }
    
    // ---------- Getter and Setter ---------

        public SoftwareComponente getSoftComp() {
        return softComp;
    }
        public SoftwareComponente getSoftCompSelec() {
        return softCompSelec;
    }
        public List<SoftwareComponente> getSoftCompList() {
        return softCompList;
    }
         public void setSoftComp(SoftwareComponente softwareComponente) {
        this.softComp = softwareComponente;
    }
         public void setSoftCompSelec(SoftwareComponente softCompSelec) {
        this.softCompSelec = softCompSelec;
    }
         public void setSoftCompList(List<SoftwareComponente> softCompList ) {
        this.softCompList = softCompList;
    }    

    //--------- Metodos ---------
    
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            softCompList = scfl.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void crearSoftwareComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = scfl.create(softComp);
            if (creado) {
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
                softComp = new SoftwareComponente();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarSoftwareComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = scfl.remove(softCompSelec);
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

    public void modificarSoftwareComponente() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean modificado = false;
        try {
            modificado = scfl.edit(softCompSelec);
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
