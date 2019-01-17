/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.HardwareComponente;
import edu.sv.uesocc.facades.HardwareComponenteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 *
 * @author o-a19
 */
@Named(value = "hardwareComponenteMB")
@ViewScoped
public class HardwareComponenteMB implements Serializable {

    @EJB
    private HardwareComponenteFacadeLocal hcFacade;
    
    private HardwareComponente hC;
    private HardwareComponente hcSeleccionado;
    private List<HardwareComponente> hcList = new ArrayList<>();

    public HardwareComponenteMB() {
    }

    public HardwareComponente gethC() {
        return hC;
    }

    public void sethC(HardwareComponente hC) {
        this.hC = hC;
    }

    public HardwareComponente getHcSeleccionado() {
        return hcSeleccionado;
    }

    public void setHcSeleccionado(HardwareComponente hcSeleccionado) {
        this.hcSeleccionado = hcSeleccionado;
    }

    public List<HardwareComponente> getHcList() {
        return hcList;
    }

    public void setHcList(List<HardwareComponente> hcList) {
        this.hcList = hcList;
    }

}
