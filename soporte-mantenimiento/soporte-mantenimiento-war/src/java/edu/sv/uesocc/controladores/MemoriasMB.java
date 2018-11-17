/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Memorias;
import edu.sv.uesocc.facades.MemoriasFacadeLocal;
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
@Named(value = "memoriasMB")
@ViewScoped
public class MemoriasMB implements Serializable {

    @EJB
    private MemoriasFacadeLocal memoriasFacade;

    private Memorias memory;
    private Memorias memSelect;
    private List<Memorias> memList = new ArrayList<>();
    

    public MemoriasMB() {
    }
    @PostConstruct
    public void init() {
        memory = new Memorias();
        memSelect = new Memorias();
        obtenerTodas();
    }

    public Memorias getMemory() {
        return memory;
    }

    public void setMemory(Memorias memory) {
        this.memory = memory;
    }

    public Memorias getMemSelect() {
        return memSelect;
    }

    public void setMemSelect(Memorias memSelect) {
        this.memSelect = memSelect;
    }

    public List<Memorias> getMemList() {
        return memList;
    }

    public void setMemList(List<Memorias> memList) {
        this.memList = memList;
    }

    public void obtenerTodas() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            memList = memoriasFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));

        }
    }

    public void agregarMemoria() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado= memoriasFacade.create(memory);
            if (creado) {
                memory = new Memorias();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarMemoria() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = memoriasFacade.remove(memory);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Memoria eliminada"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se ha podido eliminar memoria seleccionada"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void editarMemoria() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean editado = false;
        try {
            editado = memoriasFacade.edit(memSelect);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Memoria modificada"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningun cambio fue efectuado en memoria seleccionada"));
            }
            obtenerTodas();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

}
