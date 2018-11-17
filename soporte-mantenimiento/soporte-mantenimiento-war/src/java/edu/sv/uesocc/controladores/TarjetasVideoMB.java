/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.TarjetasVideo;
import edu.sv.uesocc.facades.TarjetasVideoFacadeLocal;
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
@Named(value = "tarjetasVideoMB")
@ViewScoped
public class TarjetasVideoMB implements Serializable {

    @EJB
    private TarjetasVideoFacadeLocal tarjetasVideoFacade;

    private TarjetasVideo tarjeta;
    private TarjetasVideo tarjetaSeleccionada;
    private List<TarjetasVideo> tarjetaList = new ArrayList<>();

    public TarjetasVideoMB() {
    }

    @PostConstruct
    public void init() {
        tarjeta = new TarjetasVideo();
        tarjetaSeleccionada = new TarjetasVideo();
        obtenerTodos();
    }

    public TarjetasVideo getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetasVideo tarjeta) {
        this.tarjeta = tarjeta;
    }

    public TarjetasVideo getTarjetaSeleccionada() {
        return tarjetaSeleccionada;
    }

    public void setTarjetaSeleccionada(TarjetasVideo tarjetaSeleccionada) {
        this.tarjetaSeleccionada = tarjetaSeleccionada;
    }

    public List<TarjetasVideo> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<TarjetasVideo> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    private void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tarjetaList = tarjetasVideoFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarTarjetaVideo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = tarjetasVideoFacade.create(tarjeta);
            if (creado) {
                tarjeta = new TarjetasVideo();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarTarjetaVideo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = tarjetasVideoFacade.remove(tarjeta);
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

    public void editarTarjetaVideo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean editado = false;
        try {
            editado = tarjetasVideoFacade.edit(tarjeta);
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
