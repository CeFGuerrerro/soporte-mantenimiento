
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Ubicaciones;
import edu.sv.uesocc.facades.UbicacionesFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


@Named(value = "ubicacionesMB")
@ViewScoped
public class UbicacionesMB implements Serializable {

    @EJB
    private UbicacionesFacadeLocal ubicf;
    
    private List<Ubicaciones> ubicList = new ArrayList<>();
    private Ubicaciones ubic;
    private Ubicaciones ubicSeleccionado;
    
    public UbicacionesMB() {
    }
    
    @PostConstruct
    private void init(){
        ubic = new Ubicaciones();
        ubicSeleccionado = new Ubicaciones();
        obtenerTodos();
    }

    public List<Ubicaciones> getUbicList() {
        return ubicList;
    }

    public void setUbicList(List<Ubicaciones> ubicList) {
        this.ubicList = ubicList;
    }

    public Ubicaciones getUbic() {
        return ubic;
    }

    public void setUbic(Ubicaciones ubic) {
        this.ubic = ubic;
    }

    public Ubicaciones getUbicSeleccionado() {
        return ubicSeleccionado;
    }

    public void setUbicSeleccionado(Ubicaciones ubicSeleccionado) {
        this.ubicSeleccionado = ubicSeleccionado;
    }
    
    
    public void obtenerTodos(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try{
            ubicList = ubicf.findAll();
        }catch(Exception e){
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
    
    public void crearUbicacion(){
         FacesContext contexto = FacesContext.getCurrentInstance();
         try{
             boolean creado = ubicf.create(ubic);
             if(creado){
                 ubic = new Ubicaciones();
                 contexto.addMessage(null, new FacesMessage("Registro guardado"));
             }else{
                 contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
             }
             obtenerTodos();
         }catch(Exception e){
             contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
         }
    }
    
    public void modificarUbicacion(){
         FacesContext contexto = FacesContext.getCurrentInstance();
         try{
             boolean modificado = ubicf.edit(ubicSeleccionado);
             if(modificado){
                 contexto.addMessage(null, new FacesMessage("Registro modificado"));
             }else{
                 contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro"));
             }
             obtenerTodos();
         }catch(Exception e){
             contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
         }
    }
    
    public void eliminarUbicacion(){
         FacesContext contexto = FacesContext.getCurrentInstance();
         try{
             boolean eliminado = ubicf.remove(ubicSeleccionado);
             if(eliminado){
                 contexto.addMessage(null, new FacesMessage("Registro eliminado"));
             }else{
                 contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro"));
             }
             obtenerTodos();
         }catch(Exception e){
             contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
         }
    }
}
