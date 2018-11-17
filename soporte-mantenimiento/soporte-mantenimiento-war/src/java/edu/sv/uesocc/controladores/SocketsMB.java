/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Sockets;
import edu.sv.uesocc.facades.SocketsFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "socketsMB")
@ViewScoped
public class SocketsMB implements Serializable {

    @EJB
    private SocketsFacadeLocal socketsFacade;

    private Sockets socket;
    private Sockets socketSeleccionado;
    private List<Sockets> socketList = new ArrayList<>();

    public SocketsMB() {
    }

    @PostConstruct
    public void init() {
        socket = new Sockets();
        socketSeleccionado = new Sockets();
        obtenerTodos();
    }

    public Sockets getSocket() {
        return socket;
    }

    public void setSocket(Sockets socket) {
        this.socket = socket;
    }

    public Sockets getSocketSeleccionado() {
        return socketSeleccionado;
    }

    public void setSocketSeleccionado(Sockets socketSeleccionado) {
        this.socketSeleccionado = socketSeleccionado;
    }

    public List<Sockets> getSocketList() {
        return socketList;
    }

    public void setSocketList(List<Sockets> socketList) {
        this.socketList = socketList;
    }

    private void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            socketList = socketsFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void agregarSocket() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado = false;
        try {
            creado = socketsFacade.create(socket);
            if (creado) {
                socket = new Sockets();
                contexto.addMessage(null, new FacesMessage("Registro creado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void eliminarSocket() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean eliminado = false;
        try {
            eliminado = socketsFacade.remove(socket);
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

    public void editarSocket() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean editado = false;
        try {
            editado = socketsFacade.edit(socketSeleccionado);
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
