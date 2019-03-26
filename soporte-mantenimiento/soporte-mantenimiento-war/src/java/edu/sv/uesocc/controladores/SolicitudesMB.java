package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Solicitudes;
import edu.sv.uesocc.facades.SolicitudesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "solicitudesMB")
@SessionScoped
public class SolicitudesMB implements Serializable {

    @EJB
    private SolicitudesFacadeLocal solicitudEJB;
    
    private Solicitudes solicitud = new Solicitudes();
    private List<Solicitudes> solicitudes;
    
    public SolicitudesMB() {
        
    }
    
    public void init(){
        solicitudes = solicitudEJB.findAll();
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
    
}
