package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Solicitudes;
import edu.sv.uesocc.entidades.Tipo;
import edu.sv.uesocc.entidades.Usuarios;
import edu.sv.uesocc.facades.EquiposFacadeLocal;
import edu.sv.uesocc.facades.ResponsablesFacadeLocal;
import edu.sv.uesocc.facades.SolicitudesFacadeLocal;
import edu.sv.uesocc.facades.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "solicitudUsuarioMB")
@ViewScoped
public class SolicitudUsuarioMB implements Serializable {

    @EJB
    private EquiposFacadeLocal equipoEJB;
    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    @EJB
    private ResponsablesFacadeLocal respEJB;
    @EJB
    private SolicitudesFacadeLocal soliciEJB;

    private Solicitudes solici = new Solicitudes();
    private Usuarios usuario = new Usuarios();
    private Equipos equp = new Equipos();
    private Responsables resp = new Responsables();
    private List<Equipos> equipList = new ArrayList<>();
    private List<Responsables> respList = new ArrayList<>();
    private List<Tipo> tipoList;
    private int paso = 0;
    private int tipo;
    private boolean tipoProblema;
    private boolean paso1 = true;
    private boolean paso2;
    private boolean paso3;
    private boolean paso4;
    private boolean equipo;

    @PostConstruct
    public void init() {
        tipoList = Arrays.asList(new Tipo(1,"Problema con mi equipo (UES)"), new Tipo (2,"Problema un equipo en la Unidad/Area"), new Tipo(2,"Otro..."));
    }

    public List<Tipo> getTipoList() {
        return tipoList;
    }

    public List<Responsables> getRespList() {
        return respList;
    }

    public void setRespList(List<Responsables> respList) {
        this.respList = respList;
    }

    public List<Equipos> getEquipList() {
        return equipList;
    }

    public void setEquipList(List<Equipos> equipList) {
        this.equipList = equipList;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(boolean tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public boolean isPaso1() {
        return paso1;
    }

    public void setPaso1(boolean paso1) {
        this.paso1 = paso1;
    }

    public boolean isPaso2() {
        return paso2;
    }

    public void setPaso2(boolean paso2) {
        this.paso2 = paso2;
    }

    public boolean isPaso3() {
        return paso3;
    }

    public void setPaso3(boolean paso3) {
        this.paso3 = paso3;
    }

    public boolean isPaso4() {
        return paso4;
    }

    public void setPaso4(boolean paso4) {
        this.paso4 = paso4;
    }

    public Solicitudes getSolici() {
        return solici;
    }

    public void setSolici(Solicitudes solici) {
        this.solici = solici;
    }

    public boolean isEquipo() {
        return equipo;
    }

    public void setEquipo(boolean equipo) {
        this.equipo = equipo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Responsables getResp() {
        return resp;
    }

    public void setResp(Responsables resp) {
        this.resp = resp;
    }

    public void tipoProb() {
        resp = new Responsables();
        equp = new Equipos();
        tipoProblema = true;
    }

    public void resposableEquipo() {
        equp = new Equipos();
        equipList = equipoEJB.findPorResponsable(resp);
        if (equipList.size() > 1) {
            equipo = true;
        } else {
            equp = equipList.get(0);
        }
    }

    public void obtenerResponsable() {
        respList = respEJB.findPorUbicacion(usuario.getIdUbicacion());
    }

    public Equipos getEqup() {
        return equp;
    }

    public void setEqup(Equipos equp) {
        this.equp = equp;
    }

    public void irPaso1() {
        this.paso = 0;
        this.paso1 = true;
        this.paso2 = false;
        this.equipo = false;
        usuario = new Usuarios();
        resp = new Responsables();
        equp = new Equipos();
    }

    public void irPaso2() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Comprueba si viene del paso 1
        if (paso1) {
            boolean rs = usuarioEJB.iniciarSesion(usuario);
            if (rs) {
                this.paso = 1;
                this.paso1 = false;
                this.paso2 = true;
                this.equipo = false;
                equp = new Equipos();
                resp = new Responsables();
                obtenerResponsable();
            } else {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "El usuario o la contrasenha no coinciden."));
            }
        } else {
            this.paso2 = true;
            this.paso3 = false;
            this.equipo = false;
            tipo = 0;
            tipoProblema = false;
            solici = new Solicitudes();
            equp = new Equipos();
            resp = new Responsables();
            solici = new Solicitudes();
        }
    }

    public void irPaso3() {
        this.paso = 2;
        this.paso2 = false;
        this.paso3 = true;
        this.equipo = false;
    }

    public void irPaso4() {
        this.paso = 3;
        this.paso3 = false;
        this.paso4 = true;
    }
    
    public void enviar(){
        
    }
}
