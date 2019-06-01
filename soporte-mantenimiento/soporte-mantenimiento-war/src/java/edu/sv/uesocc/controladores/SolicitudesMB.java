package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Solicitudes;
import edu.sv.uesocc.facades.SolicitudesFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "solicitudesMB")
@ViewScoped
public class SolicitudesMB implements Serializable {

    @EJB
    private SolicitudesFacadeLocal solicitudEJB;
    
    private Solicitudes solicitud = new Solicitudes();
    private List<Solicitudes> solicitudes;
    
    private boolean renderedImagen = false;
    private boolean renderedInfo = true;
    
    public SolicitudesMB() {
        
    }
    
    @PostConstruct
    public void init(){
        obtenerSolicictudes();
    }
    
    public List<Solicitudes> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitudes> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Solicitudes getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitudes solicitud) {
        this.solicitud = solicitud;
    }

    public boolean isRenderedImagen() {
        return renderedImagen;
    }

    public void setRenderedImagen(boolean renderedImagen) {
        this.renderedImagen = renderedImagen;
    }

    public boolean isRenderedInfo() {
        return renderedInfo;
    }

    public void setRenderedInfo(boolean renderedInfo) {
        this.renderedInfo = renderedInfo;
    }
    
    public void obtenerSolicictudes(){
        try {
            solicitudes = solicitudEJB.findOrdenados();
        } catch (Exception e) {
        }
    }
    
    public void render(){
        renderedInfo = false;
        renderedImagen = true;
        visto();
    }
    
    public void visto(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado;
        try {
            solicitud.setEstado(true);
            creado = solicitudEJB.edit(solicitud);
            if(creado){
                for(Solicitudes lista: solicitudes){
                    if(lista.getIdSolicitud() == solicitud.getIdSolicitud()){
                        lista.setEstado(true);
                    }
                }
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage("Algo malo paso!"));
        }
    }
    
    public void marcarNo(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado;
        try {
            solicitud.setEstado(false);
            creado = solicitudEJB.edit(solicitud);
            if(creado){
                for(Solicitudes lista: solicitudes){
                    if(lista.getIdSolicitud() == solicitud.getIdSolicitud()){
                        lista.setEstado(false);
                    }
                }
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage("Algo malo paso!"));
        }
    }
}
