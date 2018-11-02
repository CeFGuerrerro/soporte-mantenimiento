
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Marcas;
import edu.sv.uesocc.facades.MarcasFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "marcasMB")
@SessionScoped
public class MarcasMB implements Serializable {

    @EJB
    private MarcasFacadeLocal marf;
    
    private Marcas marc;
    private Marcas marcSeleccionada;
    private List<Marcas> marcList = new ArrayList<>();

    public MarcasMB() {
    }
    
    @PostConstruct
    private void init(){
        marc = new Marcas();
        marcSeleccionada = new Marcas();
        obtenerTodos();
    }

    public Marcas getMarc() {
        return marc;
    }

    public void setMarc(Marcas marc) {
        this.marc = marc;
    }

    public Marcas getMarcSeleccionada() {
        return marcSeleccionada;
    }

    public void setMarcSeleccionada(Marcas marcSeleccionada) {
        this.marcSeleccionada = marcSeleccionada;
    }

    public List<Marcas> getMarcList() {
        return marcList;
    }

    public void setMarcList(List<Marcas> marcList) {
        this.marcList = marcList;
    }
    
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            marcList = marf.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void crearMarca() {
        boolean creado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           creado = marf.create(marc);
           if(creado){
               marc = new Marcas();
               contexto.addMessage(null, new FacesMessage("Registro guardado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void eliminarMarca() {
        boolean eliminado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           eliminado = marf.remove(marcSeleccionada);
           if(eliminado){
               contexto.addMessage(null, new FacesMessage("Registro eliminado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo eliminar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
    
    public void modificarMarca() {
        boolean modificado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
           modificado = marf.edit(marcSeleccionada);
           if(modificado){
               contexto.addMessage(null, new FacesMessage("Registro modificado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
}
