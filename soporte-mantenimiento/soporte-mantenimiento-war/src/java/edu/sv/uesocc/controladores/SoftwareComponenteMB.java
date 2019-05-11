/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.SoftwareComponente;
import edu.sv.uesocc.facades.SoftwareComponenteFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author o-a19
 */
@Named(value = "softwareComponenteMB")
@ViewScoped
public class SoftwareComponenteMB implements Serializable {

    @EJB
    private SoftwareComponenteFacadeLocal scfl;

    // Declaracion de entidades 
    private boolean estadoInfo=true;
    private boolean estadoTabla = false;
    
    private SoftwareComponente softComp;
    private SoftwareComponente softCompSelec;
    private List<SoftwareComponente> softCompList;
     private List<SoftwareComponente> softcompDisponibleList = new ArrayList<>();

    public SoftwareComponenteMB() {
    }

    @PostConstruct
    private void init() {
        softComp = new SoftwareComponente();
        softCompSelec = new SoftwareComponente();
        
//        obtenerTodos();
    }

    // ---------- Getter and Setter ---------

    public boolean isEstadoInfo() {
        return estadoInfo;
    }

    public void setEstadoInfo(boolean estadoInfo) {
        this.estadoInfo = estadoInfo;
    }

    public boolean isEstadoTabla() {
        return estadoTabla;
    }

    public void setEstadoTabla(boolean estadoTabla) {
        this.estadoTabla = estadoTabla;
    }
    
    
    
    
    public SoftwareComponente getSoftComp() {
        return softComp;
    }

    public SoftwareComponente getSoftCompSelec() {
        return softCompSelec;
    }

    public List<SoftwareComponente> getSoftCompList() {
        return softCompList;
    }

    public void setSoftComp(SoftwareComponente softwareComponente) {
        this.softComp = softwareComponente;
    }

    public void setSoftCompSelec(SoftwareComponente softCompSelec) {
        this.softCompSelec = softCompSelec;
    }

    public void setSoftCompList(List<SoftwareComponente> softCompList) {
        this.softCompList = softCompList;
    }

    //--------- Metodos ---------
    
    
    public void sofwareAsignable() {
     estadoInfo = false;
     estadoTabla= true; 
    }
    
    
    
    
}
