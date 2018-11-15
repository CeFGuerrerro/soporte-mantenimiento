package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Equipos;
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

    private Equipos equip;
    private Equipos equipSeleccionado;
    private List<Equipos> equipList = new ArrayList<>();

    private Componentes compSeleccionado;
    private List<Componentes> compList = new ArrayList<>();
    private List<Componentes> compSeleccionadoList = new ArrayList<>();
    private List<Componentes> compSeleccionadoDupList = new ArrayList<>();

    public EquiposMB() {
    }

    @PostConstruct
    private void init() {
        equip = new Equipos();
        equipSeleccionado = new Equipos();
        compSeleccionado = new Componentes();
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

    public void obtenerTodos() {
        equipList = equipf.findAll();
    }

    public Componentes getCompSeleccionado() {
        return compSeleccionado;
    }

    public void setCompSeleccionado(Componentes compSeleccionado) {
        this.compSeleccionado = compSeleccionado;
    }

    public List<Componentes> getCompList() {
        return compList;
    }

    public void setCompList(List<Componentes> compList) {
        this.compList = compList;
    }

    public List<Componentes> getCompSeleccionadoList() {
        return compSeleccionadoList;
    }

    public void setCompSeleccionadoList(List<Componentes> compSeleccionadoList) {
        this.compSeleccionadoList = compSeleccionadoList;
    }

    public List<Componentes> getCompSeleccionadoDupList() {
        return compSeleccionadoDupList;
    }

    public void setCompSeleccionadoDupList(List<Componentes> compSeleccionadoDupList) {
        this.compSeleccionadoDupList = compSeleccionadoDupList;
    }

//    Metodos publicos 
    public void agregarComponentes() {
        equip.setComponentesList(compList);
    }

    public void quitarComponentes() {
        compList.remove(compSeleccionado);
    }

    public void cargarComponentesEquipoSeleccionado() {
        compSeleccionadoDupList.clear();

        for (Componentes c : equipSeleccionado.getComponentesList()) {
            compSeleccionadoDupList.add(c);
        }
    }

    public void agregarComponentesEquipoSelecionado() {
        for (Componentes c : compSeleccionadoList) {
            compSeleccionadoDupList.add(c);
        }
    }

    public void quitarComponenteEquipoSeleccionado() {
        compSeleccionadoDupList.remove(compSeleccionado);
    }

    public void crearEquipo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            if (!compList.isEmpty()) {
                boolean creado = equipf.create(equip);
                if (creado) {
                    for (Componentes c : equip.getComponentesList()) {
                        c.setIdEquipo(equip);
                        c.setAsignado(true);
                        compf.edit(c);
                    }
                    equip = new Equipos();
                    compList.clear();
                    contexto.addMessage(null, new FacesMessage("Registro guardado"));
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro"));
                }
            } else {
                contexto.addMessage(null, new FacesMessage("Por favor agregue componentes al equipo"));
            }
            obtenerTodos();
        } catch (Exception e) {

        }
    }

    public void modificarEquipo() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            if (compSeleccionadoDupList.isEmpty()) {
                contexto.addMessage(null, new FacesMessage("Por favor agregue componentes al equipo"));
            } else { 
                compSeleccionadoList.clear();
                for(Componentes c: equipSeleccionado.getComponentesList()){
                    compSeleccionadoList.add(c);
                }
                equipSeleccionado.setComponentesList(compSeleccionadoDupList);
                 boolean modificado = equipf.edit(equipSeleccionado);
                
                for(Componentes c: compSeleccionadoDupList){
                    if(!compSeleccionadoList.contains(c)){
                        c.setIdEquipo(equipSeleccionado);
                        c.setAsignado(true);
                        compf.edit(c);
                    }
                }
                for(Componentes c: compSeleccionadoList){
                    if(!compSeleccionadoDupList.contains(c)){
                        c.setAsignado(false);
                        c.setIdEquipo(null);
                        compf.edit(c);
                    }
                }
                if(modificado){
                    contexto.addMessage(null, new FacesMessage("Registro modificado"));
                }else {
                    contexto.addMessage(null, new FacesMessage("No se pudo modificar el registro"));
                }
                compSeleccionadoDupList.clear();
                compSeleccionadoList.clear();
                obtenerTodos();
            }
        } catch (Exception e) {

        }

    }

}
