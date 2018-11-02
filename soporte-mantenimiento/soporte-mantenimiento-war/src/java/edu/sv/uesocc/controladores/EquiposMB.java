
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import edu.sv.uesocc.facades.EquiposFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "equiposMB")
@SessionScoped
public class EquiposMB implements Serializable {

    @EJB
    private EquiposFacadeLocal equipf;
    private ComponentesFacadeLocal compf;
    
    private Equipos equip;
    private Equipos equipSeleccionado;
    private List<Equipos> equipList = new ArrayList<>();
    List<Componentes> compList = new ArrayList<>();

    
    public EquiposMB() {
    }
    
    @PostConstruct
    private void init(){
        equip = new Equipos();
        equipSeleccionado = new Equipos();
        obtenerTodos();
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
    
    
    public void obtenerTodos(){
        equipList = equipf.findAll();
    }
    
}
