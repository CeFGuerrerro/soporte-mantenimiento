/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Loggin;
import edu.sv.uesocc.entidades.Permisos;
import edu.sv.uesocc.facades.LogginFacadeLocal;
import edu.sv.uesocc.facades.PermisosFacadeLocal;
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
 * @author o-a19
 */
@Named(value = "userAdminMB")
@ViewScoped
public class UserAdminMB implements Serializable {

    @EJB
    private LogginFacadeLocal loginFacade;

    @EJB
    private PermisosFacadeLocal permisosFacade;

    private Loggin admin;
    private Loggin adminSel;
    private Permisos acceso;
    private Permisos accesoSel;
    private List<Loggin> adminList = new ArrayList<>();

    public UserAdminMB() {

    }

    @PostConstruct
    private void init() {
        admin = new Loggin();
        adminSel = new Loggin();
        acceso = new Permisos();
        accesoSel = new Permisos();
        obtenerTodos();
    }

    public Loggin getAdmin() {
        return admin;
    }

    public void setAdmin(Loggin admin) {
        this.admin = admin;
    }

    public List<Loggin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Loggin> adminList) {
        this.adminList = adminList;
    }

    public Loggin getAdminSel() {
        return adminSel;
    }

    public void setAdminSel(Loggin adminSel) {
        this.adminSel = adminSel;
    }

    public Permisos getAccesoSel() {
        return accesoSel;
    }

    public void setAccesoSel(Permisos accesoSel) {
        this.accesoSel = accesoSel;
    }

    public boolean crearAdmin() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = loginFacade.create(admin);
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        return registrado;
    }

    public void editarAdmin() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = loginFacade.edit(adminSel);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                adminSel = new Loggin();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        obtenerTodos();
    }

    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            adminList = loginFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    private boolean crearRegistroPermisos() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            acceso.setIdLoggin(admin);
            registrado = permisosFacade.create(acceso);
            if (registrado) {
                acceso = new Permisos();
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        return registrado;
    }

    public void crear() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (crearAdmin()) {
            if (crearRegistroPermisos()) {
                contexto.addMessage(null, new FacesMessage("Administrador registrado"));
                obtenerTodos();
            }
        } else {
            contexto.addMessage(null, new FacesMessage("No se pudo registrar"));
        }
    }

    public void buscarPermisos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            accesoSel = permisosFacade.obtenerAccesos(adminSel);
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
    }

    public void editarPermisos() {
        boolean editado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            editado = permisosFacade.edit(accesoSel);
            if (editado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                adminSel = new Loggin();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo editar el registro."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        obtenerTodos();
    }

    public void eliminarPermisos() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        accesoSel = permisosFacade.obtenerAccesos(adminSel);

        try {
            eliminado = permisosFacade.remove(accesoSel);
            if (eliminado) {
                eliminado = loginFacade.remove(adminSel);
                if (eliminado) {
                    contexto.addMessage(null, new FacesMessage("Registro eliminado."));
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro"));
                }
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro."));
            }
            obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
    }

}
