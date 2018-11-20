package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Cronograma;
import edu.sv.uesocc.facades.CronogramaFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@Named(value = "cronogramaMB")
@ViewScoped
public class CronogramaMB implements Serializable {

    public CronogramaMB() {
    }

    @EJB
    private CronogramaFacadeLocal cronogramaEJB;
    private List<Cronograma> actividades;
    private Cronograma actividad = new Cronograma();
    private Cronograma seleccion = new Cronograma();

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    public List<Cronograma> getActividades() {
        return actividades;
    }

    public void setActividades(List<Cronograma> actividades) {
        this.actividades = actividades;
    }

    public Cronograma getActividad() {
        return actividad;
    }

    public void setActividad(Cronograma actividad) {
        this.actividad = actividad;
    }

    public Cronograma getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Cronograma seleccion) {
        this.seleccion = seleccion;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    @PostConstruct
    public void init() {
        actividades = cronogramaEJB.findAll();
        eventModel = llenarChronograma(actividades);
    }

    public ScheduleModel llenarChronograma(List<Cronograma> lista) {
        ScheduleEvent eventos = new DefaultScheduleEvent();
        ScheduleModel modelo = new DefaultScheduleModel();

        for (Cronograma actividadLista : lista) {
            modelo.addEvent(new DefaultScheduleEvent());
        }

        return modelo;
    }

    public void addEvent() {
        //Si el Id es null se tomo como que no existe y se agrega al modelo y a la base de datos
        if (event.getId() == null) {
            boolean registrado = false;
            FacesContext contexto = FacesContext.getCurrentInstance();

            try {

                registrado = cronogramaEJB.create(actividad);
                if (registrado) {
                    contexto.addMessage(null, new FacesMessage("Actividad agregada."));
                    actividad = new Cronograma();
                    eventModel.addEvent(event);
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
                }

            } catch (Exception e) {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
            }
            actividades = cronogramaEJB.findAll();

        } else {
            //Si el Id no es null se toma como una actividad ya existente y se edita.
            boolean registrado = false;
            FacesContext contexto = FacesContext.getCurrentInstance();
            try {
                registrado = cronogramaEJB.edit(seleccion);
                if (registrado) {
                    contexto.addMessage(null, new FacesMessage("Actividad editada."));
                    actividad = new Cronograma();
                    seleccion = new Cronograma();
                    eventModel.updateEvent(event);
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
                }
            } catch (Exception e) {
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
            }
            actividades = cronogramaEJB.findAll();
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
