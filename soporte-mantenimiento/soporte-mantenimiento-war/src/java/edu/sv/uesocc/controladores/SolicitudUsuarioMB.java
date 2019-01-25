package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Usuarios;
import edu.sv.uesocc.facades.EquiposFacadeLocal;
import edu.sv.uesocc.facades.ResponsablesFacadeLocal;
import edu.sv.uesocc.facades.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named(value = "solicitudUsuarioMB")
@ViewScoped
public class SolicitudUsuarioMB implements Serializable {

    @EJB
    private EquiposFacadeLocal equipoEJB;
    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    @EJB
    private ResponsablesFacadeLocal respEJB;

    private Usuarios usuario = new Usuarios();
    private Equipos equp = new Equipos();
    private Responsables resp = new Responsables();
    private List<Equipos> equipList = new ArrayList<>();
    private List<Responsables> respList = new ArrayList<>();
    private int paso = 0;
    private boolean paso1 = true;
    private boolean paso2;
    private boolean paso3;
    private boolean paso4;
    private boolean equipo;

    @PostConstruct
    public void init() {

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

    public void resposableEquipo() {
        equipo = true;
        equipList = equipoEJB.findPorResponsable(resp);
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
            equp = new Equipos();
            resp = new Responsables();
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
}
