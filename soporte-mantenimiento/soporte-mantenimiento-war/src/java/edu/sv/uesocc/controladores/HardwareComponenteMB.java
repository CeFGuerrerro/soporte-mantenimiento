/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Discos;
import edu.sv.uesocc.entidades.DiscosComponente;
import edu.sv.uesocc.entidades.FuenteComponente;
import edu.sv.uesocc.entidades.Fuentes;
import edu.sv.uesocc.entidades.Memorias;
import edu.sv.uesocc.entidades.MemoriasComponente;
import edu.sv.uesocc.entidades.MotherboardComponente;
import edu.sv.uesocc.entidades.Motherboards;
import edu.sv.uesocc.entidades.ProcesadorComponente;
import edu.sv.uesocc.entidades.Procesadores;
import edu.sv.uesocc.entidades.TarjetasVideo;
import edu.sv.uesocc.entidades.TarjetasVideoComponente;
import edu.sv.uesocc.facades.ComponentesFacadeLocal;
import edu.sv.uesocc.facades.DiscosFacadeLocal;
import edu.sv.uesocc.facades.FuentesFacadeLocal;
import edu.sv.uesocc.facades.MemoriasFacadeLocal;
import edu.sv.uesocc.facades.MotherboardsFacadeLocal;
import edu.sv.uesocc.facades.ProcesadoresFacadeLocal;
import edu.sv.uesocc.facades.TarjetasVideoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import org.primefaces.event.NodeSelectEvent;
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
    private ComponentesFacadeLocal compFacade;
    @EJB
    private MemoriasFacadeLocal memoriasFacade;
    @EJB
    private DiscosFacadeLocal discosFacade;
    @EJB
    private ProcesadoresFacadeLocal procesadoresFacade;
    @EJB
    private MotherboardsFacadeLocal motherboardsFacade;
    @EJB
    private FuentesFacadeLocal fuentesFacade;
    @EJB
    private TarjetasVideoFacadeLocal tarjetasFacade;

    private boolean estadoInfo = true;
    private boolean estadoTabla = false;
    private List<Componentes> contenedoresHw = new ArrayList<>();
    
    private List<Discos> discosDisponibles = new ArrayList<>();
    private List<Memorias> memoriasDisponibles = new ArrayList<>();
    private List<Procesadores> procesadoresDisponibles = new ArrayList<>();
    private List<Motherboards> motherboardsDisponibles = new ArrayList<>();
    private List<TarjetasVideo> tarjetasDisponibles = new ArrayList<>();
    private List<Fuentes> fuentesDisponibles = new ArrayList<>();

    //Variables treetable
    private TreeNode root = new DefaultTreeNode("Root Node", null);
    private TreeNode singleSelectedTreeNode;
    
    private DiscosComponente discoAsignado;
    private MemoriasComponente memoriaAsignada;
    private ProcesadorComponente procesadorAsignado;
    private MotherboardComponente motherboardAsignada;
    private FuenteComponente fuentedAsignada;
    private TarjetasVideoComponente tvAsignada;

    @PostConstruct
    private void init() {
        contenedor();
    }

    public HardwareComponenteMB() {

        // Creacion de nodos principales de treetable
        TreeNode discos = new DefaultTreeNode("Discos", this.root);
        TreeNode memorias = new DefaultTreeNode("Memorias RAM", this.root);
        TreeNode tarjetasV = new DefaultTreeNode("Tarjeta de Video", this.root);
        TreeNode procesador = new DefaultTreeNode("Procesador", this.root);
        TreeNode motherboard = new DefaultTreeNode("Motherboard", this.root);
        TreeNode fuente = new DefaultTreeNode("Fuente de Voltaje", this.root);
        // Creacion de subnodos de treetable
        TreeNode discoAsignado = new DefaultTreeNode(this.discoAsignado, discos);
        TreeNode memAsignada = new DefaultTreeNode(this.memoriaAsignada, memorias);
        TreeNode tarjetaAsignada = new DefaultTreeNode(this.tvAsignada, tarjetasV);
        TreeNode procAsignado = new DefaultTreeNode(this.procesadorAsignado, procesador);
        TreeNode motherAsignada = new DefaultTreeNode(this.motherboardAsignada, motherboard);
        TreeNode fuenteAsignada = new DefaultTreeNode(this.fuentedAsignada, fuente);
    }

    public List<Memorias> getMemoriasDisponibles() {
        return memoriasDisponibles;
    }

    public void setMemoriasDisponibles(List<Memorias> memoriasDisponibles) {
        this.memoriasDisponibles = memoriasDisponibles;
    }

    public List<Procesadores> getProcesadoresDisponibles() {
        return procesadoresDisponibles;
    }

    public void setProcesadoresDisponibles(List<Procesadores> procesadoresDisponibles) {
        this.procesadoresDisponibles = procesadoresDisponibles;
    }

    public List<Motherboards> getMotherboardsDisponibles() {
        return motherboardsDisponibles;
    }

    public void setMotherboardsDisponibles(List<Motherboards> motherboardsDisponibles) {
        this.motherboardsDisponibles = motherboardsDisponibles;
    }

    public List<TarjetasVideo> getTarjetasDisponibles() {
        return tarjetasDisponibles;
    }

    public void setTarjetasDisponibles(List<TarjetasVideo> tarjetasDisponibles) {
        this.tarjetasDisponibles = tarjetasDisponibles;
    }

    public List<Fuentes> getFuentesDisponibles() {
        return fuentesDisponibles;
    }

    public void setFuentesDisponibles(List<Fuentes> fuentesDisponibles) {
        this.fuentesDisponibles = fuentesDisponibles;
    }

    public List<Discos> getDiscosDisponibles() {
        return discosDisponibles;
    }

    public void setDiscosDisponibles(List<Discos> discosDisponibles) {
        this.discosDisponibles = discosDisponibles;
    }

    public TreeNode getSingleSelectedTreeNode() {
        return singleSelectedTreeNode;
    }

    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode) {
        this.singleSelectedTreeNode = singleSelectedTreeNode;
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

    public List<Componentes> getContenedoresHw() {
        return contenedoresHw;
    }

    public void setContenedoresHw(List<Componentes> contenedoresHw) {
        this.contenedoresHw = contenedoresHw;
    }

    public void onNodeSelect(NodeSelectEvent event) {
        System.out.println("Node Data ::" + event.getTreeNode().getData() + " :: Selected");
    }

//cambio informacion columna derecha tabla
    public void hardware() {
        estadoInfo = false;
        estadoTabla = true;
    }

//Trae lista de contenedores de hardware
    public void contenedor() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            contenedoresHw = compFacade.ComponenteContenedoresHW();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error! contenedores hardware", e.getMessage()));
        }
    }
//Cargar listas a tabla t_hardware

    public void selectNode() {
        // System.out.println("Nodo seleccionado: " + this.singleSelectedTreeNode.getData());

        if (singleSelectedTreeNode.getData() == "Discos") {
            discosDisponibles = discosFacade.findDisponibles();
        } else if (singleSelectedTreeNode.getData() == "Memorias RAM") {
            memoriasDisponibles = memoriasFacade.findDisponibles();
        } else if (singleSelectedTreeNode.getData() == "Tarjeta de Video") {
            tarjetasDisponibles = tarjetasFacade.findDisponibles();
        } else if (singleSelectedTreeNode.getData() == "Procesador") {
            procesadoresDisponibles = procesadoresFacade.findDisponibles();
        } else if (singleSelectedTreeNode.getData() == "Motherboard") {
            motherboardsDisponibles = motherboardsFacade.findDisponibles();
        } else if (singleSelectedTreeNode.getData() == "Fuente de Voltaje") {
            fuentesDisponibles = fuentesFacade.findDisponibles();
        } else {
        }

    }

    public void view(ActionEvent e) {
        System.out.println("View action has invoked against node :: " + this.singleSelectedTreeNode.getData());
    }

}
