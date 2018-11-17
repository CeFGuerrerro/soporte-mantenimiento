/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Motherboards;
import edu.sv.uesocc.facades.MotherboardsFacadeLocal;
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
@Named(value = "motherboardsMB")
@ViewScoped
public class MotherboardsMB implements Serializable {

    @EJB
    private MotherboardsFacadeLocal motherboardsFacade;

    private Motherboards placa;
    private Motherboards placaSeleccionada;
    private List<Motherboards> placaList = new ArrayList<>();

    public MotherboardsMB() {
    }

    @PostConstruct
    public void init() {
        placa = new Motherboards();
        placaSeleccionada = new Motherboards();
        obtenerTodos();
    }

    public Motherboards getPlaca() {
        return placa;
    }

    public void setPlaca(Motherboards placa) {
        this.placa = placa;
    }

    public Motherboards getPlacaSeleccionada() {
        return placaSeleccionada;
    }

    public void setPlacaSeleccionada(Motherboards placaSeleccionada) {
        this.placaSeleccionada = placaSeleccionada;
    }

    public List<Motherboards> getPlacaList() {
        return placaList;
    }

    public void setPlacaList(List<Motherboards> placaList) {
        this.placaList = placaList;
    }

    private void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            placaList = motherboardsFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarMotherboard() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado= motherboardsFacade.create(placa);
            if (creado) {
                placa = new Motherboards();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarMotherboard() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = motherboardsFacade.remove(placa);
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

    public void editarMotherboard() {
                FacesContext contexto = FacesContext.getCurrentInstance();

        boolean editado = false;
        try {
            editado = motherboardsFacade.edit(placa);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));
            } else {
                contexto.addMessage(null, new FacesMessage("Ningun cambio fue efectuado en registro seleccionado"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
}
