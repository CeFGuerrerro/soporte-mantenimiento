/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Discos;
import edu.sv.uesocc.entidades.DiscosComponente;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import edu.sv.uesocc.facades.TiposComponenteFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author gaby
 */
@Named(value = "hardwareComponenteMB")
@ViewScoped
public class HardwareComponenteMB implements Serializable {

    @EJB
    private TiposComponenteFacadeLocal tpFacade;
    @EJB
    private ComponentesFacadeLocal compFacade;

    private Componentes comp;
    private boolean estadoInfo = true;
    private boolean estadoTabla = false;
    private TreeNode root = new DefaultTreeNode("Root Node", null);
    private TreeNode[] selectedNode;
    private DiscosComponente discoAsignado;

    private List<Componentes> compList = new ArrayList<>();

    private void init() {
        // componenteContenedoresHw();
        root = createHardware();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

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

    public Componentes getComp() {
        return comp;
    }

    public void setComp(Componentes comp) {
        this.comp = comp;
    }

    public List<Componentes> getCompList() {
        return compList;
    }

    public void setCompList(List<Componentes> compList) {
        this.compList = compList;
    }

    public void componenteContenedoresHw() {
        //traer los componentes que tengan contenedorHw = true
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            //  compList = compFacade.findContenedoresHw();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

//cambio informacion columna derecha tabla
    public void hardware() {
        estadoInfo = false;
        estadoTabla = true;
    }

    public TreeNode createHardware() {
        TreeNode discos = new DefaultTreeNode("Discos","-", root);
      //  TreeNode memorias = new DefaultTreeNode("Memorias", root);
      //  TreeNode tarjetasVideo = new DefaultTreeNode("Tarjetas de Video", root);
        //Rama discos
        TreeNode diskAsig = new DefaultTreeNode(discoAsignado.getIdDiscos().getNumeroSerie(),discoAsignado.getEstado(), discos);
        return root;
    }
}
