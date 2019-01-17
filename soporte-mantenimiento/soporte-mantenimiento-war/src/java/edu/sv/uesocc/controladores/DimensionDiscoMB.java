/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.DimensionDisco;
import edu.sv.uesocc.facades.DimensionDiscoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gaby
 */
@Named(value = "dimensionDiscoMB")
@ViewScoped
public class DimensionDiscoMB implements Serializable {

    @EJB
    private DimensionDiscoFacadeLocal sizeDiscFacade;
    private DimensionDisco size;
    private DimensionDisco sizeSeleccionado;
    private List<DimensionDisco> sizeList = new ArrayList<>();

    public DimensionDiscoMB() {
    }

    @PostConstruct
    public void init() {
        size = new DimensionDisco();
        sizeSeleccionado = new DimensionDisco();
        obtenerTodos();
    }

    public DimensionDisco getSize() {
        return size;
    }

    public void setSize(DimensionDisco size) {
        this.size = size;
    }

    public DimensionDisco getSizeSeleccionado() {
        return sizeSeleccionado;
    }

    public void setSizeSeleccionado(DimensionDisco sizeSeleccionado) {
        this.sizeSeleccionado = sizeSeleccionado;
    }

    public List<DimensionDisco> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<DimensionDisco> sizeList) {
        this.sizeList = sizeList;
    }

    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            sizeList = sizeDiscFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarDimension() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            creado = sizeDiscFacade.create(size);
            if (creado) {
                size = new DimensionDisco();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarDimension() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = sizeDiscFacade.remove(sizeSeleccionado);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se ha podido eliminar registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void editarDimension() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = sizeDiscFacade.edit(sizeSeleccionado);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningún cambio fue efectuado en registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
}
