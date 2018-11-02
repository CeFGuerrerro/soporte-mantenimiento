
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Ubicaciones;
import edu.sv.uesocc.facades.UbicacionesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "ubicacionesMB")
@SessionScoped
public class UbicacionesMB implements Serializable {

    @EJB
    private UbicacionesFacadeLocal ubicf;
    
    private List<Ubicaciones> ubicList = new ArrayList<>();

    
    public UbicacionesMB() {
    }
    
    @PostConstruct
    private void init(){
        obtenerTodos();
    }

    public List<Ubicaciones> getUbicList() {
        return ubicList;
    }

    public void setUbicList(List<Ubicaciones> ubicList) {
        this.ubicList = ubicList;
    }
    
    public void obtenerTodos(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try{
            ubicList = ubicf.findAll();
        }catch(Exception e){
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
    
    
}
