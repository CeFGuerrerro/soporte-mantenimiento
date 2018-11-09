/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Software;
import edu.sv.uesocc.facades.SoftwareFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author o-a19
 */
@Named(value = "softwareMB")
@SessionScoped
public class SoftwareMB implements Serializable {

    @EJB
    private SoftwareFacadeLocal sfl;

    private Software software;
    private Software softwareSeleccionado;
    private List<Software> softwareList = new ArrayList<>();

    /**
     * Creates a new instance of SoftwareMB
     */
    public SoftwareMB() {
    }

    @PostConstruct
    private void init() {
        software = new Software();
        softwareSeleccionado = new Software();
        obtenerTodos();
    }

    public Software getSoftware() {
        return software;
    }

    public Software getSoftwareSeleccionado() {
        return softwareSeleccionado;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public void setSoftwareSeleccionado(Software softwareSeleccionado) {
        this.softwareSeleccionado = softwareSeleccionado;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            softwareList = sfl.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void crearSoftware() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado = sfl.create(software);
            if (creado) {
                software = new Software();
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarSoftware() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = sfl.remove(softwareSeleccionado);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void modificarSoftware() {
        boolean modificado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            modificado = sfl.edit(softwareSeleccionado);
            if (modificado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

}
