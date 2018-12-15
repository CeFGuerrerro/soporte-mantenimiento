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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

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
    private ComponentesEquipo comp = new ComponentesEquipo(); // Para equipos nuevos
    private ComponentesEquipo compSeleccionado = new ComponentesEquipo(); //Para equipos seleccionados
    private List<Equipos> equipList = new ArrayList<>(); // Lista de todos los equipos
    private List<ComponentesEquipo> compEquipList = new ArrayList<>(); // Lista de Componentes Por Equipo
    private List<Componentes> compList = new ArrayList<>(); // Lista de solo componentes cuando se crea equipo


    public EquiposMB() {
    }

    @PostConstruct
    private void init() {
        equip = new Equipos();
        equipSeleccionado = new Equipos();
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
    
//    Metodos publicos

    public void obtenerTodos() {
        equipList = equipf.findAll();
    }

    public List<ComponentesEquipo> getCompEquipList() {
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
    public void obtenerEquipos(){
        equipList = equipf.findAll();
    }
    
    public void agregarComponentes(){
        for(Componentes c : compList){
            
        }
    }
    
    public void obtenerComponentesPorEquipo(){
        
    }
    
    public void crearEquipo(){
        
    }

}
