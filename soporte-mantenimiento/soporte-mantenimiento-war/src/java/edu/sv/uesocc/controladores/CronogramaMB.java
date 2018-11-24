package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Cronograma;
import edu.sv.uesocc.facades.CronogramaFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
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
        eventModel = llenarCronograma(actividades);
    }

    public ScheduleModel llenarCronograma(List<Cronograma> lista) {
        ScheduleEvent evento;
        ScheduleModel modelo = new DefaultScheduleModel();

        for (Cronograma actividadLista : lista) {
            Date fechaFin = agregarHoras(actividadLista.getFechaFin());
            evento = new DefaultScheduleEvent(actividadLista.getNombreEvento(), actividadLista.getFechaInicio(), fechaFin);
            modelo.addEvent(evento);
            evento.setId(actividadLista.getIdCronograma().toString());
        }

        return modelo;
    }

    public Date agregarHoras(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 23);
        return calendar.getTime();
    }

    public void dltEvent() {

        boolean registrado = false;
        FacesMessage message = null;

        try {
            Integer id = Integer.parseInt(event.getId());
            actividad.setIdCronograma(id);
            actividad.setNombreEvento(event.getTitle());
            actividad.setFechaInicio(event.getStartDate());
            actividad.setFechaFin(event.getEndDate());
            registrado = cronogramaEJB.remove(actividad);
            if (registrado) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad eliminada", null);
                addMessage(message);
                eventModel = new DefaultScheduleModel();
                actividad = new Cronograma();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo registrar", null);
                addMessage(message);
            }
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage());
            addMessage(message);
        }
        actividades = cronogramaEJB.findAll();
        eventModel = llenarCronograma(actividades);
        event = new DefaultScheduleEvent();
    }

    public void addEvent() {
        //Si el Id es null se tomo como que no existe y se agrega al modelo y a la base de datos
        boolean registrado = false;
        FacesMessage message = null;
        
        if (event.getId() == null) {

            try {
                actividad.setNombreEvento(event.getTitle());
                actividad.setFechaInicio(event.getStartDate());
                actividad.setFechaFin(event.getEndDate());
                registrado = cronogramaEJB.create(actividad);
                if (registrado) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad agregada", null);
                    addMessage(message);
                    actividad = new Cronograma();
                    eventModel = new DefaultScheduleModel();
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo registrar", null);
                    addMessage(message);
                }

            } catch (Exception e) {
                message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage());
                addMessage(message);
            }
            actividades = cronogramaEJB.findAll();
            eventModel = llenarCronograma(actividades);

        } else {
            //Si el Id no es null se toma como una actividad ya existente y se edita.
            try {
                Integer id = Integer.parseInt(event.getId());
                actividad.setIdCronograma(id);
                actividad.setNombreEvento(event.getTitle());
                actividad.setFechaInicio(event.getStartDate());
                actividad.setFechaFin(event.getEndDate());
                registrado = cronogramaEJB.edit(actividad);
                if (registrado) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad modificada", null);
                    addMessage(message);
                    actividad = new Cronograma();
                    eventModel = new DefaultScheduleModel();
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo registrar", null);
                    addMessage(message);
                }
            } catch (Exception e) {
                message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage());
                addMessage(message);
            }
            actividades = cronogramaEJB.findAll();
            eventModel = llenarCronograma(actividades);
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

        ScheduleEvent onMove = event.getScheduleEvent();
        boolean registrado = false;
        FacesMessage message = null;

        try {
            Integer id = Integer.parseInt(onMove.getId());
            actividad.setIdCronograma(id);
            actividad.setNombreEvento(onMove.getTitle());
            //Date desde = onMoveDesde(onMove.getStartDate(), event.getDayDelta());
            actividad.setFechaInicio(onMove.getStartDate());
            System.out.println(actividad.getFechaInicio());
            actividad.setFechaFin(onMove.getEndDate());
            registrado = cronogramaEJB.edit(actividad);
            if (registrado) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad desplazada.", "Dias: " + event.getDayDelta());
                System.out.println(event.getDayDelta() + " " + event.getMinuteDelta());
                System.out.println(actividad.getFechaInicio() + " --- " + actividad.getFechaFin());
                System.out.println(onMove.getStartDate() + " --- " + onMove.getEndDate());
                addMessage(message);
                actividad = new Cronograma();
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se registro el cambio en la DB");
                addMessage(message);
            }
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage());
            addMessage(message);
        }
        actividades = cronogramaEJB.findAll();

    }
    
    public Date onMoveDesde(Date date, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
