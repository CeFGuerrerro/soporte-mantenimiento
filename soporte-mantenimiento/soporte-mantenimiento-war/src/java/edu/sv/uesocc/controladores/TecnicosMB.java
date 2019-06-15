package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Tecnicos;
import edu.sv.uesocc.facades.TecnicosFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

@Named(value = "tecnicosMB")
@ViewScoped
public class TecnicosMB implements Serializable {

    public TecnicosMB() {
    }

    @EJB
    private TecnicosFacadeLocal tecnicoEJB;
    private List<Tecnicos> tecnicos = new ArrayList<>();
    private Tecnicos tecnico;
    private Tecnicos seleccion;

    public List<Tecnicos> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnicos> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Tecnicos getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnicos tecnico) {
        this.tecnico = tecnico;
    }

    public Tecnicos getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Tecnicos seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        obtenerTodos();
        tecnico = new Tecnicos();
        seleccion = new Tecnicos();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tecnico.setEstado(true);
            registrado = tecnicoEJB.create(tecnico);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Tecnico registrado."));
                tecnico = new Tecnicos();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        obtenerTodos();
    }

    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tecnicoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
                tecnico = new Tecnicos();
                seleccion = new Tecnicos();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        obtenerTodos();
    }

    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tecnicos = tecnicoEJB.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

    public void filtrar(AjaxBehaviorEvent e) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            String filter = (String) ((UIOutput) e.getSource()).getValue();
            tecnicos.clear();
            tecnicos = tecnicoEJB.findAllWithFilter(Integer.parseInt(filter));
        } catch (NumberFormatException ex) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", ex.getMessage()));
        }
    }

}
