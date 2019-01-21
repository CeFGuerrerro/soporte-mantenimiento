package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.ComponentesEquipo;
import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.facades.ComponentesEquipoFacadeLocal;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import edu.sv.uesocc.facades.EquiposFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@Named(value = "equiposMB")
@ViewScoped
public class EquiposMB implements Serializable {

    @EJB
    private EquiposFacadeLocal equipf;
    @EJB
    private ComponentesFacadeLocal compf;
    @EJB
    private ComponentesEquipoFacadeLocal compEquipfl;

    private Equipos equip;
    private Equipos equipSeleccionado;
    private ComponentesEquipo comp = new ComponentesEquipo();
    private ComponentesEquipo compSeleccionado = new ComponentesEquipo(); //Para equipos seleccionados
    private List<Equipos> equipList = new ArrayList<>(); // Lista de todos los equipos
    private List<ComponentesEquipo> compEquipList = new ArrayList<>(); // Lista de Componentes Por Equipo
    private List<Componentes> compList = new ArrayList<>(); // Lista de solo componentes cuando se crea equipo
    private DualListModel<Componentes> compAsignar;
    private List<Componentes> compPorAsignar;
    private List<Componentes> compDisponibles = new ArrayList<>(); //*****
    private boolean accion;

    public EquiposMB() {
    }

    @PostConstruct
    private void init() {
        equip = new Equipos();
        equipSeleccionado = new Equipos();
        obtenerEquipos();
        obtenerComponentesDisponibles();
    }

    public boolean isAccion() {
        return accion;
    }

    public void setAccion(boolean accion) {
        this.accion = accion;
    }

    public void setAccionCleanning(boolean accion) {
        this.accion = accion;
        compList = new ArrayList<>();
    }

    public DualListModel<Componentes> getCompAsignar() {
        return compAsignar;
    }

    public void setCompAsignar(DualListModel<Componentes> compAsignar) {
        this.compAsignar = compAsignar;
    }

    public Equipos getEquip() {
        return equip;
    }

    public void setEquip(Equipos equip) {
        this.equip = equip;
    }

    public Equipos getEquipSeleccionado() {
        return equipSeleccionado;
    }

    public void setEquipSeleccionado(Equipos equipSeleccionado) {
        this.equipSeleccionado = equipSeleccionado;
    }

    public List<Equipos> getEquipList() {
        return equipList;
    }

    public void setEquipList(List<Equipos> equipList) {
        this.equipList = equipList;
    }

    public ComponentesEquipo getCompSeleccionado() {
        return compSeleccionado;
    }

    public void setCompSeleccionado(ComponentesEquipo compSeleccionado) {
        this.compSeleccionado = compSeleccionado;
    }

    public List<ComponentesEquipo> getCompEquipList() {
        return compEquipList;
    }
    
    public List<ComponentesEquipo> compEquipSelectedList() {
        obtenerComponentesPorEquipo();
        return compEquipList;
    }

    public void setCompEquipList(List<ComponentesEquipo> compEquipList) {
        this.compEquipList = compEquipList;
    }

    public List<Componentes> getCompList() {
        return compList;
    }

    public void setCompList(List<Componentes> compList) {
        this.compList = compList;
    }

//    Metodos publicos 
    public void obtenerEquipos() {
        equipList = equipf.findAll();
    }

    public void obtenerComponentesDisponibles() {

        compPorAsignar = new ArrayList<>();
        List<Componentes> compDisponibles = compf.findDisponibles();
        compAsignar = new DualListModel<>(compDisponibles, compPorAsignar);

    }

    public void obtenerComponentesPorEquipo() {
        compEquipList = compEquipfl.findHistorial(equipSeleccionado);
    }

    public void crearEquipo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean creadoCE;
            boolean actu;
            boolean creado = equipf.create(equip);
            int compG = 0;
            if (creado) {
                Date date = new Date();
                obtenerEquipos();
                for (Componentes lista : compList) {
                    comp = new ComponentesEquipo();
                    Equipos ultimoEquipo = new Equipos();
                    ultimoEquipo = equipList.get(equipList.size() - 1);
                    comp.setIdEquipo(ultimoEquipo);
                    comp.setIdComponente(lista);
                    comp.setFechaVinculado(date);
                    creadoCE = compEquipfl.create(comp);
                    if (creadoCE) {
                        compG++;
                        lista.setAsignado(true);
                        actu = compf.edit(lista);
                    } else {
                        contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro de un componente!"));
                    }
                }
                equip = new Equipos();
                comp = new ComponentesEquipo();
                contexto.addMessage(null, new FacesMessage("Registro guardado"));
                contexto.addMessage(null, new FacesMessage("Componentes asignados: " + compG));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }
            obtenerEquipos();
            obtenerComponentesDisponibles();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void editarEquipo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean crearCE;
            boolean actu;
            boolean editar = equipf.edit(equipSeleccionado);
            int compG = 0;
            if (editar) {
                Date date = new Date();
                if (compList.size() > 0) {
                    for (Componentes lista : compList) {
                        comp = new ComponentesEquipo();
                        comp.setIdEquipo(equipSeleccionado);
                        comp.setIdComponente(lista);
                        comp.setFechaVinculado(date);
                        crearCE = compEquipfl.create(comp);
                        if (crearCE) {
                            compG++;
                            lista.setAsignado(true);
                            actu = compf.edit(lista);
                        } else {
                            contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro de un componente!"));
                        }
                    }
                }
                equipSeleccionado = new Equipos();
                compList = new ArrayList<>();
                comp = new ComponentesEquipo();
                setAccion(false);

                contexto.addMessage(null, new FacesMessage("Registro editado"));
                contexto.addMessage(null, new FacesMessage("Componentes asignados: " + compG));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
            }

            obtenerEquipos();
            obtenerComponentesDisponibles();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void showCleanning() {
        obtenerComponentesDisponibles();
        compList = new ArrayList<>();
        this.accion = false;
    }

    public void desvincular() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        Date date = new Date();
        compSeleccionado.setFechaDesvinculado(date);
        compSeleccionado.setEstado(false);
        try {
            boolean edit = compEquipfl.edit(compSeleccionado);
            boolean editEstado;

            if (edit) {
                Componentes estado = compSeleccionado.getIdComponente();
                estado.setAsignado(false);
                editEstado = compf.edit(estado);
                equipSeleccionado = new Equipos();
                contexto.addMessage(null, new FacesMessage("Registro editado"));
            }
            obtenerEquipos();
            obtenerComponentesDisponibles();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
        }
    }

    public void observaciones() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            boolean edit = compEquipfl.edit(compSeleccionado);

            if (edit) {
                equipSeleccionado = new Equipos();
                contexto.addMessage(null, new FacesMessage("Registro editado"));
            }
            obtenerEquipos();
            obtenerComponentesDisponibles();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
        }

    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Componentes) item).getNumeroSerie()).append("<br />");
        }

        compList = compAsignar.getTarget();

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
}
