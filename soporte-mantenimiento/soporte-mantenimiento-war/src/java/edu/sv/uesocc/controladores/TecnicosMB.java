package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Tecnicos;
import edu.sv.uesocc.facades.TecnicosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "tecnicosMB")
@SessionScoped
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
        tecnico = new Tecnicos();
        seleccion = new Tecnicos();

        tecnicos = tecnicoEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = tecnicoEJB.create(tecnico);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Tecnico registrado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tecnicos = tecnicoEJB.findAll();
        tecnico = null;
    }
    
    public void editar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tecnicoEJB.edit(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro editado."));
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        tecnicos = tecnicoEJB.findAll();
        seleccion = null;
    }
}
