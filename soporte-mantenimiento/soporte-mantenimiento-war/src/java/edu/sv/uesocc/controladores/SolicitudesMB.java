package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.ComponentesEquipo;
import edu.sv.uesocc.entidades.Mantenimientos;
import edu.sv.uesocc.entidades.OrdenesTrabajo;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Solicitudes;
import edu.sv.uesocc.entidades.Tecnicos;
import edu.sv.uesocc.entidades.Ubicaciones;
import edu.sv.uesocc.facades.ComponentesEquipoFacadeLocal;
import edu.sv.uesocc.facades.MantenimientosFacadeLocal;
import edu.sv.uesocc.facades.OrdenesTrabajoFacadeLocal;
import edu.sv.uesocc.facades.ResponsablesFacadeLocal;
import edu.sv.uesocc.facades.SolicitudesFacadeLocal;
import edu.sv.uesocc.facades.TecnicosFacadeLocal;
import edu.sv.uesocc.facades.UbicacionesFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    @EJB
    private MantenimientosFacadeLocal mantenimientoEJB;
    @EJB
    private UbicacionesFacadeLocal ubicacionEJB;
    @EJB
    private TecnicosFacadeLocal tecnicosEJB;
    @EJB
    private ResponsablesFacadeLocal responsablesEJB;
    @EJB
    private OrdenesTrabajoFacadeLocal ordenesTrabajoEJB;
    @EJB
    private ComponentesEquipoFacadeLocal componentesEquipoEJB;
    
    private Solicitudes solicitud = new Solicitudes();
    private Ubicaciones ubicacion = new Ubicaciones();
    private Responsables responsable = new Responsables();
    private Tecnicos tecnico = new Tecnicos();
    private Mantenimientos mantenimiento = new Mantenimientos();
    private OrdenesTrabajo ordenTrabajo = new OrdenesTrabajo();
    private List<Solicitudes> solicitudes;
    private List<Ubicaciones> ubicaciones;
    private List<Tecnicos> tecnicos;
    private List<Mantenimientos> mantenimientos;
    private List<Responsables> responsables;
    private List<ComponentesEquipo> compEquipos;
    
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

    public Ubicaciones getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicaciones ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Responsables getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsables responsable) {
        this.responsable = responsable;
    }

    public Tecnicos getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnicos tecnico) {
        this.tecnico = tecnico;
    }

    public Mantenimientos getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimientos mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public List<Ubicaciones> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicaciones> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public List<Tecnicos> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnicos> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public List<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public List<Responsables> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsables> responsables) {
        this.responsables = responsables;
    }

    public OrdenesTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenesTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public List<ComponentesEquipo> getCompEquipos() {
        return compEquipos;
    }

    public void setCompEquipos(List<ComponentesEquipo> compEquipos) {
        this.compEquipos = compEquipos;
    }

// ##############METODOS#############
    
    public void obtenerSolicictudes(){
        try {
            solicitudes = solicitudEJB.findOrdenados();
        } catch (Exception e) {
        }
    }
    
    public void obtenerUbicaciones(){
        try {
            ubicaciones = ubicacionEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void obtenerTecnicosDisponibles(){
        try {
            tecnicos = tecnicosEJB.findAllWithFilter(1);
        } catch (Exception e) {
        }
    }
    
    public void obtenerMantenimientos(){
        try {
            mantenimientos = mantenimientoEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void obtenerEquiposUbicacion(){
        try {
            compEquipos = componentesEquipoEJB.findEquiposActivosUbicacion(solicitud.getIdUbicacion());
        } catch (Exception e) {
        }
    }
    
    public List<ComponentesEquipo> filtroComponenteEquipo(String query) {
        List<ComponentesEquipo> filtro = new ArrayList<>();
         
        for (ComponentesEquipo lista : compEquipos) {
            if(lista.getIdComponente().getNumeroInventario().toLowerCase().contains(query)) {
                filtro.add(lista);
            }
        }
         
        return filtro;
    }
    
   /* public void render(){
        renderedInfo = false;
        renderedImagen = true;
        visto();
    }
    
 /*   public void visto(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        boolean creado;
        try {
            solicitud.setEstado(true);
            creado = solicitudEJB.edit(solicitud);
            if(creado){
                solicitudes.stream().filter((lista) -> (Objects.equals(lista.getIdSolicitud(), solicitud.getIdSolicitud()))).forEachOrdered((lista) -> {
                    lista.setEstado(true);
                });
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
                solicitudes.stream().filter((lista) -> (Objects.equals(lista.getIdSolicitud(), solicitud.getIdSolicitud()))).forEachOrdered((lista) -> {
                    lista.setEstado(false);
                });
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage("Algo malo paso!"));
        }
    }
    */
    public void ordenFromSolicitud(){
        ubicacion = solicitud.getIdUbicacion();
        responsable = solicitud.getIdResponsable();
        
    }
}
