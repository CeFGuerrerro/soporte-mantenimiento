package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.DiaNoLaboral;
import edu.sv.uesocc.facades.DiaNoLaboralFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "diaNoLaboralMB")
@SessionScoped
public class DiaNoLaboralMB implements Serializable {

    public DiaNoLaboralMB() {
    }

    @EJB
    private DiaNoLaboralFacadeLocal diaEJB;
    private List<DiaNoLaboral> dias;
    private DiaNoLaboral dia;
    private DiaNoLaboral seleccion;

    public List<DiaNoLaboral> getDias() {
        return dias;
    }

    public void setDias(List<DiaNoLaboral> dias) {
        this.dias = dias;
    }

    public DiaNoLaboral getDia() {
        return dia;
    }

    public void setDia(DiaNoLaboral dia) {
        this.dia = dia;
    }

    public DiaNoLaboral getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(DiaNoLaboral seleccion) {
        this.seleccion = seleccion;
    }

    @PostConstruct
    private void init() {
        dia = new DiaNoLaboral();
        seleccion = new DiaNoLaboral();
        dias = diaEJB.findAll();
    }

    public void registrar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();

        try {

            registrado = diaEJB.create(dia);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Solucion registrada."));
                dia = new DiaNoLaboral();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo registrar."));
            }
 
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        dias = diaEJB.findAll();
    }

    public void eliminar() {
        boolean registrado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            registrado = diaEJB.remove(seleccion);
            if (registrado) {
                contexto.addMessage(null, new FacesMessage("Registro eliminado."));
                seleccion = new DiaNoLaboral();
            } else {
                contexto.addMessage(null, new FacesMessage("No se pudo eliminar."));
            }
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error:", e.getMessage()));
        }
        dias = diaEJB.findAll();
    }
}
