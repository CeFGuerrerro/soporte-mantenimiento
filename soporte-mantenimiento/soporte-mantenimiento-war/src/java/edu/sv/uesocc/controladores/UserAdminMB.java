/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Loggin;
import edu.sv.uesocc.facades.LogginFacadeLocal;
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
public class UserAdminMB implements Serializable{

    @EJB
    private LogginFacadeLocal loginFacade;
    
    private Loggin admin;
    private Loggin adminSel;
    private List<Loggin> adminList = new ArrayList<>();

    public UserAdminMB() {

    }
    
    @PostConstruct
    private void init(){
        admin = new Loggin();
        adminSel = new Loggin();
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
    
    public void crearAdmin() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = loginFacade.create(admin);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Tecnico registrado."));
                admin = new Loggin();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        obtenerTodos();
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
    
    public void obtenerTodos(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            adminList = loginFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
}
