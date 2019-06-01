package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Solicitudes;
import edu.sv.uesocc.entidades.TiposSolicitud;
import edu.sv.uesocc.entidades.Usuarios;
import edu.sv.uesocc.facades.ResponsablesFacadeLocal;
import edu.sv.uesocc.facades.SolicitudesFacadeLocal;
import edu.sv.uesocc.facades.TiposSolicitudFacadeLocal;
import edu.sv.uesocc.facades.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "solicitudUsuarioMB")
@ViewScoped
public class SolicitudUsuarioMB implements Serializable{

    @Inject
    @Push
    private PushContext solicitud;

    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    @EJB
    private ResponsablesFacadeLocal respEJB;
    @EJB
    private SolicitudesFacadeLocal soliciEJB;
    @EJB
    private TiposSolicitudFacadeLocal tipoSoliciEJB;

    private Solicitudes solici = new Solicitudes();
    private TiposSolicitud tipoSolici = new TiposSolicitud();
    private Usuarios usuario = new Usuarios();
    private Responsables resp = new Responsables();
    private List<Equipos> equipList = new ArrayList<>();
    private List<Responsables> respList = new ArrayList<>();
    private List<TiposSolicitud> tipoList;
    private int paso = 0;
    private int codigo;
    private boolean tipoProblema;
    private boolean paso1 = true;
    private boolean paso2;
    private boolean paso3;
    private boolean paso4;

    @PostConstruct
    public void init() {
        tipoList = tipoSoliciEJB.findAll();
    }

    public TiposSolicitud getTipoSolici() {
        return tipoSolici;
    }

    public void setTipoSolici(TiposSolicitud tipoSolici) {
        this.tipoSolici = tipoSolici;
    }

    public List<TiposSolicitud> getTipoList() {
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
        tipoProblema = true;
    }

    public void obtenerResponsable() {
        respList = respEJB.findPorUbicacion(usuario.getIdUbicacion());
    }

    public void irPaso1() {
        this.paso = 0;
        this.paso1 = true;
        this.paso2 = false;
        usuario = new Usuarios();
        resp = new Responsables();
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
                resp = new Responsables();
                obtenerResponsable();
            } else {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "El usuario o la contrasenha no coinciden."));
            }
        } else {
            this.paso2 = true;
            this.paso3 = false;
            tipoProblema = false;
            solici = new Solicitudes();
            resp = new Responsables();
            solici = new Solicitudes();
        }
    }

    public void irPaso3() {
        this.paso = 2;
        this.paso2 = false;
        this.paso3 = true;
        this.paso4 = false;
    }

    public void irPaso4() {
        this.paso = 3;
        this.paso3 = false;
        this.paso4 = true;
    }

    public void enviar() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        Date date = new Date();

        try {
            solici.setIdTipoSolicitud(tipoSolici);
            solici.setIdResponsable(resp);
            solici.setIdUbicacion(usuario.getIdUbicacion());
            solici.setFechaSolicitud(date);
            boolean creado = soliciEJB.create(solici);
            if (creado) {
                creado = false;
                int randomNum = ThreadLocalRandom.current().nextInt(100, 999 + 1);
                codigo = randomNum * 100000;
                solici.setCodigoSeguimiento(codigo + soliciEJB.findLastRecord().getIdSolicitud());
                creado = soliciEJB.edit(solici);
                if (creado) {
                    send(resp.getNombre() + " ( " + resp.getIdUbicacion().getNombre() + " )");
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo crear el codigo de seguimiento (!)"));
                } 
            } else {
                contexto.addMessage(null, new FacesMessage("Hubo un problema al enviar la solicitud"));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));
        }

    }

    public void send(Object message) {
        System.out.println(message);
        solicitud.send(message);
    }

    public void enviarSW() {
        send("Esto es una prueba :v");
    }

}
