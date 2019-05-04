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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author o-a19
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    @EJB
    private LogginFacadeLocal logginFacade;
    @EJB
    private PermisosFacadeLocal permisosFacade;

    private Loggin usuario = new Loggin();
    private Loggin loginUser = new Loggin();
    private Permisos accesos = new Permisos();

    public LoginMB() {
    }

    @PostConstruct
    public void init() {

    }

    public Loggin getUsuario() {
        return usuario;
    }

    public void setUsuario(Loggin usuario) {
        this.usuario = usuario;
    }

    public Permisos getAccesos() {
        return accesos;
    }

    public void setAccesos(Permisos accesos) {
        this.accesos = accesos;
    }

    public String login() {
        try {
            loginUser = logginFacade.iniciarSesion(usuario);
            if (null != loginUser) {
                FacesContext contexto = FacesContext.getCurrentInstance();
                contexto.getExternalContext().getSessionMap().put("user", loginUser.getIdTecnico().getNombre());
                obtenerAccesos(loginUser);
                return "/admin/EquiposForm.jsf?faces-redirect=true";
            } else {
                return "/inicio/LoginForm.jsf?faces-redirect=true";
            }
        } catch (Exception e) {
            return "/inicio/LoginForm.jsf?faces-redirect=true";
        }

    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/inicio/LoginForm.jsf?faces-redirect=true";
    }

    public void obtenerAccesos(Loggin id) {
        try {
            accesos = permisosFacade.obtenerAccesos(id);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",e.getMessage()));
        }
    }
}
