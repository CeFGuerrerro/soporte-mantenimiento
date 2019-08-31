/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.SoftwareComponente;
import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Software;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import edu.sv.uesocc.facades.SoftwareComponenteFacadeLocal;
import edu.sv.uesocc.facades.SoftwareFacadeLocal;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author o-a19
 */
@Named(value = "softwareComponenteMB")
@ViewScoped
public class SoftwareComponenteMB implements Serializable {

    @EJB
    private SoftwareComponenteFacadeLocal scfl;
    @EJB
    private ComponentesFacadeLocal cfl;
    @EJB
    private SoftwareFacadeLocal sfl;

    // Declaracion de entidades 
    private boolean estadoInfo = true;
    private boolean estadoTabla = false;

    private SoftwareComponente softComp = new SoftwareComponente();
    private SoftwareComponente softCompSelec;
    private Componentes compSelect;

    private List<SoftwareComponente> softCompList;
    private List<SoftwareComponente> SAporSC; // Software asignado por Software componente
    private List<Componentes> contenedorSoftList; // Lista de componentes que son contenedores de software
    private DualListModel<Software> scAsignar; // Lista de software por asignar
    private List<Software> sfList = new ArrayList<>(); // Lista de transferir

    public SoftwareComponenteMB() {
    }

    @PostConstruct
    private void init() {
        softCompSelec = new SoftwareComponente();
        List<Software> sfPorAsignar = new ArrayList<>();
        List<Software> disponibles = new ArrayList<>();

        scAsignar = new DualListModel<>(disponibles, sfPorAsignar);
    }

    // ---------- Getter and Setter ---------
    public DualListModel<Software> getScAsignar() {
        return scAsignar;
    }

    public void setScAsignar(DualListModel<Software> scAsignar) {
        this.scAsignar = scAsignar;
    }

    public List<Componentes> getContenedorSoftList() {
        return contenedorSoftList;
    }

    public void setContenedorSoftList(List<Componentes> contenedorSoftList) {
        this.contenedorSoftList = contenedorSoftList;
    }

    public boolean isEstadoInfo() {
        return estadoInfo;
    }

    public void setEstadoInfo(boolean estadoInfo) {
        this.estadoInfo = estadoInfo;
    }

    public boolean isEstadoTabla() {
        return estadoTabla;
    }

    public void setEstadoTabla(boolean estadoTabla) {
        this.estadoTabla = estadoTabla;
    }

    public SoftwareComponente getSoftCompSelec() {
        return softCompSelec;
    }

    public List<SoftwareComponente> getSoftCompList() {
        return softCompList;
    }

    public void setSoftCompSelec(SoftwareComponente softCompSelec) {
        this.softCompSelec = softCompSelec;
    }

    public void setSoftCompList(List<SoftwareComponente> softCompList) {
        this.softCompList = softCompList;
    }

    public Componentes getCompSelect() {
        return compSelect;
    }

    public void setCompSelect(Componentes compSelect) {
        this.compSelect = compSelect;
    }

    public List<SoftwareComponente> getSAporSC() {
        return SAporSC;
    }

    public void setSAporSC(List<SoftwareComponente> SAporSC) {
        this.SAporSC = SAporSC;
    }

    //--------- METODOS ---------
    public void obtenerSwDisponible() {
        List<Software> sfPorAsignar = new ArrayList<>();
        List<Software> disponibles = new ArrayList<>();
        disponibles = sfl.findSWNoAsignado(compSelect);
        
        System.out.println(disponibles.get(0));

        scAsignar = new DualListModel<>(disponibles, sfPorAsignar);
    }

    public void contenedor() {
        try {
            contenedorSoftList = cfl.ListasoftComponentes();
        } catch (Exception e) {
        }
    }

    public void sofwareAsignable() {
        estadoInfo = false;
        estadoTabla = true;
        mostrarTabla();
        obtenerSDisponible();
    }

    public void nuevoSC() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean creadoSC;
            boolean actul;

            if (!sfList.isEmpty()) {
                for (Software lista : sfList) {
                    softComp = new SoftwareComponente();
                    softComp.setIdSoftware(lista);
                    softComp.setIdComponente(compSelect);
                    boolean creado = scfl.create(softComp);

                    if (creado) {
                        softComp = new SoftwareComponente();
                        contexto.addMessage(null, new FacesMessage("Registro guardado"));

                    } else {
                        contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
                    }
                }
                softComp = new SoftwareComponente();
            }
            obtenerSwDisponible();

        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void editarSC() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean editar = scfl.edit(softCompSelec);

            if (editar) {
                contexto.addMessage(null, new FacesMessage("Registro modificado"));

            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo editar el registro!"));
            }
            obtenerSwDisponible();

        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }

    }

    public void eliminarSC() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            eliminado = scfl.remove(softCompSelec);
            if (eliminado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado"));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro!"));
            }
            obtenerSwDisponible();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void mostrarTabla() {
        try {
            SAporSC = scfl.buscarSoftware(compSelect);
        } catch (Exception e) {
        }
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Software) item).getIdSoftware()).append("<br />");
        }
        sfList = scAsignar.getTarget();
    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }

    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }
    
    public void obtenerSDisponible () {
    obtenerSwDisponible();
    }
}
