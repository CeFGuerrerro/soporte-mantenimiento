/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Ups;
import edu.sv.uesocc.facades.UpsFacadeLocal;
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
@Named(value = "upsMB")
@ViewScoped
public class UpsMB implements Serializable {

    @EJB
    private UpsFacadeLocal upsFacade;

    private Ups ups;
    private Ups upsSeleccionada;
    private List<Ups> upsList = new ArrayList<>();
    private Componentes comp = new Componentes();

    public UpsMB() {
    }

    @PostConstruct
    private void init() {
        ups = new Ups();
        upsSeleccionada = new Ups();
        obtenerTodos();
    }

    public Ups getUps() {
        return ups;
    }

    public void setUps(Ups ups) {
        this.ups = ups;
    }

    public Ups getUpsSeleccionada() {
        return upsSeleccionada;
    }

    public void setUpsSeleccionada(Ups upsSeleccionada) {
        this.upsSeleccionada = upsSeleccionada;
    }

    public List<Ups> getUpsList() {
        return upsList;
    }

    public void setUpsList(List<Ups> upsList) {
        this.upsList = upsList;
    }

    public Componentes getComp() {
        return comp;
    }

    public void setComp(Componentes comp) {
        this.comp = comp;
    }

    public void obtenerTodos() {
        try {
            upsList = upsFacade.findAll();
        } catch (Exception e) {

        }
    }

    public void crearUps() {
        FacesContext contexto = FacesContext.getCurrentInstance();

        try {
            if (comp.getIdComponente() == null) {
                contexto.addMessage(null, new FacesMessage("Por favor, Seleccione un componente"));
            } else {
                ups.setIdComponente(comp);
                boolean creado = upsFacade.create(ups);

                if (creado) {
                    contexto.addMessage(null, new FacesMessage("Registro guardado"));
                    ups = new Ups();
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo guadar el registro"));
                }
            }

            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
        }
    }

    public void modificarUps() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean modificado = upsFacade.edit(upsSeleccionada);

            if (modificado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
        }
    }

    public void eliminarUps() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean eliminado = upsFacade.remove(upsSeleccionada);

            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
        }
    }

}
