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
import edu.sv.uesocc.facades.DiscosComponenteFacadeLocal;
import edu.sv.uesocc.facades.DiscosFacadeLocal;
import edu.sv.uesocc.facades.FuenteComponenteFacadeLocal;
import edu.sv.uesocc.facades.FuentesFacadeLocal;
import edu.sv.uesocc.facades.MemoriasComponenteFacadeLocal;
import edu.sv.uesocc.facades.MemoriasFacadeLocal;
import edu.sv.uesocc.facades.MotherboardComponenteFacadeLocal;
import edu.sv.uesocc.facades.MotherboardsFacadeLocal;
import edu.sv.uesocc.facades.ProcesadorComponenteFacadeLocal;
import edu.sv.uesocc.facades.ProcesadoresFacadeLocal;
import edu.sv.uesocc.facades.TarjetasVideoComponenteFacadeLocal;
import edu.sv.uesocc.facades.TarjetasVideoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
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
    @EJB
    private DiscosComponenteFacadeLocal discoCompFacade;
    @EJB
    private MemoriasComponenteFacadeLocal memoriaCompFacade;
    @EJB
    private ProcesadorComponenteFacadeLocal procesadorCompFacade;
    @EJB
    private FuenteComponenteFacadeLocal fuenteCompFacade;
    @EJB
    private MotherboardComponenteFacadeLocal motherboardCompFacade;
    @EJB
    private TarjetasVideoComponenteFacadeLocal tarjetasCompFacade;

    private boolean estadoInfo = true;
    private boolean estadoTabla = false;
    private List<Componentes> contenedoresHw = new ArrayList<>();
    private List<contenedorObjetos> contenedorObj;
    private contenedorObjetos contenedorHardware;
    private contenedorObjetos hardwareSeleccionado;
    private Componentes componenteSeleccionado;
    private String nodoPrincipal = "";
    private String nodeSeleccionado;

    private Discos contDisco, reemplazoDisco, discoSeleccionado;
    private Memorias contMemorias, reemplazoMemoria;
    private Procesadores contProcesadores, reemplazoProcesador;
    private Motherboards contMotherboards, reemplazoMotherboard;
    private TarjetasVideo contTarjetas, reemplazoTV;
    private Fuentes contFuentes, reemplazoFuente;

    private DiscosComponente discosComponente = new DiscosComponente();
    private MemoriasComponente memoriaComponente = new MemoriasComponente();
    private ProcesadorComponente procesComponente = new ProcesadorComponente();
    private MotherboardComponente tarjetaMadreComponente = new MotherboardComponente();
    private TarjetasVideoComponente tarjetasVideoComponente = new TarjetasVideoComponente();
    private FuenteComponente fuentesComponente = new FuenteComponente();

    //Listado de hardware
    private List<Discos> discoList = new ArrayList<>();
    private List<Memorias> memoriasList = new ArrayList<>();
    private List<Procesadores> procesadoresList = new ArrayList<>();
    private List<Motherboards> motherboardList = new ArrayList<>();
    private List<TarjetasVideo> tarjetasVideoList = new ArrayList<>();
    private List<Fuentes> fuentesList = new ArrayList<>();

    //Componentes asignados
    private List<DiscosComponente> discoDisp = new ArrayList<>();
    private List<MemoriasComponente> memoriasDisp = new ArrayList<>();
    private List<ProcesadorComponente> procesadoresDisp = new ArrayList<>();
    private List<MotherboardComponente> motherDisp = new ArrayList<>();
    private List<TarjetasVideoComponente> tarjetasDisp = new ArrayList<>();
    private List<FuenteComponente> fuentesDisp = new ArrayList<>();

    //Componentes disponibles
    private List<Discos> discosDisponibles = new ArrayList<>();
    private List<Memorias> memoriasDisponibles = new ArrayList<>();
    private List<Procesadores> procesadoresDisponibles = new ArrayList<>();
    private List<Motherboards> motherboardsDisponibles = new ArrayList<>();
    private List<TarjetasVideo> tarjetasDisponibles = new ArrayList<>();
    private List<Fuentes> fuentesDisponibles = new ArrayList<>();

    //Variables treetable
    private TreeNode root = new DefaultTreeNode("Root Node", null);
    private TreeNode singleSelectedTreeNode;

    //Nodos principales
    private TreeNode discos;
    private TreeNode memorias;
    private TreeNode tarjetasV;
    private TreeNode procesador;
    private TreeNode motherboard;
    private TreeNode fuente;

    //SubNodos
   /* private TreeNode discAsignado;
    private TreeNode memAsignada;
    private TreeNode tarjetaAsignada;
    private TreeNode procAsignado;
    private TreeNode motherAsignada;
    private TreeNode fuenteAsignada;*/

    @PostConstruct

    private void init() {
        contenedor();
        discoSeleccionado= new Discos();
    }

    public HardwareComponenteMB() {
        // Inicializacion de nodos principales de treetable
        discos = new DefaultTreeNode("Discos", this.root);
        memorias = new DefaultTreeNode("Memorias RAM", this.root);
        tarjetasV = new DefaultTreeNode("Tarjeta de Video", this.root);
        procesador = new DefaultTreeNode("Procesador", this.root);
        motherboard = new DefaultTreeNode("Motherboard", this.root);
        fuente = new DefaultTreeNode("Fuente de Voltaje", this.root);

    }

    public Discos getContDisco() {
        return contDisco;
    }

    public void setContDisco(Discos contDisco) {
        this.contDisco = contDisco;
    }

    public contenedorObjetos getHardwareSeleccionado() {
        return hardwareSeleccionado;
    }

    public void setHardwareSeleccionado(contenedorObjetos hardwareSeleccionado) {
        this.hardwareSeleccionado = hardwareSeleccionado;
    }

    public String getNodoPrincipal() {
        return nodoPrincipal;
    }

    public void setNodoPrincipal(String nodoPrincipal) {
        this.nodoPrincipal = nodoPrincipal;
    }

    public List<DiscosComponente> getDiscoDisp() {
        return discoDisp;
    }

    public void setDiscoDisp(List<DiscosComponente> discoDisp) {
        this.discoDisp = discoDisp;
    }

    public Componentes getComponenteSeleccionado() {
        return componenteSeleccionado;
    }

    public void setComponenteSeleccionado(Componentes componenteSeleccionado) {
        this.componenteSeleccionado = componenteSeleccionado;
    }

    public List<contenedorObjetos> getContenedorObj() {
        return contenedorObj;
    }

    public void setContenedorObj(List<contenedorObjetos> contenedorObj) {
        this.contenedorObj = contenedorObj;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSingleSelectedTreeNode() {
        return singleSelectedTreeNode;
    }

    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode) {
        this.singleSelectedTreeNode = singleSelectedTreeNode;
    }

    public List<Discos> getDiscosDisponibles() {
        return discosDisponibles;
    }

    public void setDiscosDisponibles(List<Discos> discosDisponibles) {
        this.discosDisponibles = discosDisponibles;
    }

    public contenedorObjetos getContenedorObjetos() {
        return contenedorHardware;
    }

    public void setContenedorObjetos(contenedorObjetos contenedorObjetos) {
        this.contenedorHardware = contenedorObjetos;
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

//cambio informacion columna derecha tabla
    public void hardware() {
        //  limpiarListas();
        estadoInfo = false;
        estadoTabla = true;
      //  discAsignado.getChildren().clear();

        componenteAsignado();
    }

//cargar hardwareComponente asignado
    public void componenteAsignado() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {

            discoDisp = discoCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (DiscosComponente d : discoDisp) {
              TreeNode discAsignado = new DefaultTreeNode(d.getIdDiscos().getNumeroSerie() + "-" + d.getIdDiscos().getIdMarca().getNombre()
                        + "-" + d.getIdDiscos().getIdTipoDisco().getTipoDisco() + "-" + d.getIdDiscos().getIdPuerto().getTipoPuerto(), discos);
            }
            memoriasDisp = memoriaCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (MemoriasComponente m : memoriasDisp) {
             TreeNode memAsignada = new DefaultTreeNode(m.getIdMemoria().getNumeroSerie() + "-" + m.getIdMemoria().getIdMarca().getNombre()
                        + "-" + m.getIdMemoria().getIdTipo().getTipoMemoria() + "-" + m.getIdMemoria().getIdCapacidad().getCapacidad()
                        + "-" + m.getIdMemoria().getIdVelocidad().getVelocidad(), memorias);
            }
            tarjetasDisp = tarjetasCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (TarjetasVideoComponente tv : tarjetasDisp) {
             TreeNode tarjetaAsignada = new DefaultTreeNode(tv.getIdTarjetaVideo().getNumeroSerial() + "-" + tv.getIdTarjetaVideo().getIdMarca().getNombre()
                        + "-" + tv.getIdTarjetaVideo().getIdPuerto().getTipoPuerto(), tarjetasV);
            }
            procesadoresDisp = procesadorCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (ProcesadorComponente p : procesadoresDisp) {
             TreeNode procAsignado = new DefaultTreeNode(p.getIdProcesador().getNumeroSerie() + "-" + p.getIdProcesador().getIdArquitectura().getArquitectura()
                        + "-" + p.getIdProcesador().getIdModelo().getNombre() + "-" + p.getIdProcesador().getIdSocket().getSocket(), procesador);
            }
            motherDisp = motherboardCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (MotherboardComponente mb : motherDisp) {
             TreeNode motherAsignada = new DefaultTreeNode(mb.getIdMotherboard().getNumeroSerie() + "-" + mb.getIdMotherboard().getIdMarca().getNombre()
                        + "-" + mb.getIdMotherboard().getIdSocket().getSocket(), motherboard);
            }
            fuentesDisp = fuenteCompFacade.findAsignados(componenteSeleccionado.getIdComponente());
            for (FuenteComponente f : fuentesDisp) {
             TreeNode fuenteAsignada = new DefaultTreeNode(f.getIdFuente().getNumeroSerie() + "-" + f.getIdFuente().getIdModelo().getNombre()
                        + "-" + f.getIdFuente().getPotencia(), motherboard);
            }
            // System.out.println(discoDisp);
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error! al cargar hardware asignado a componente", e.getMessage()));
        }
    }

//Trae lista de contenedores de hardware
    public void contenedor() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            contenedoresHw = compFacade.ComponenteContenedoresHW();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error! al cargar contenedores hardware", e.getMessage()));
        }
    }

//Cargar listas a tabla t_hardware
    public void selectedNode(String node) {
        contenedorObj = new ArrayList<>();
        contenedorHardware = new contenedorObjetos();
        try {
            if (node == null) {
            } else if (node == "Discos") {
                nodeSeleccionado = node;
                discosDisponibles = discosFacade.findDisponibles();
                for (Discos disc : discosDisponibles) {
                    contenedorHardware.setId(disc.getIdDisco());
                    contenedorHardware.setNumeroSerie(disc.getNumeroSerie());
                    contenedorHardware.setMarca(disc.getIdMarca().getNombre());
                    contenedorHardware.setTipoObjeto(disc.getIdTipoDisco().getTipoDisco());
                    contenedorHardware.setCapacidad(disc.getIdCapacidad().getCapacidad());
                    contenedorHardware.setPuertos(disc.getIdPuerto().getTipoPuerto());
                    contenedorObj.add(contenedorHardware);
                    // System.out.println(disc.getNumeroSerie());
                }

            } else if (node == "Memorias RAM") {
                nodeSeleccionado = node;
                memoriasDisponibles = memoriasFacade.findDisponibles();
                for (Memorias mems : memoriasDisponibles) {
                    contenedorHardware.setNumeroSerie(mems.getNumeroSerie());
                    contenedorHardware.setMarca(mems.getIdMarca().getNombre());
                    contenedorHardware.setCapacidad(mems.getIdCapacidad().getCapacidad());
                    contenedorHardware.setTipoObjeto(mems.getIdTipo().getTipoMemoria());
                    contenedorHardware.setVelocidad(mems.getIdVelocidad().getVelocidad());
                    contenedorObj.add(contenedorHardware);
                }

            } else if (node == "Tarjeta de Video") {
                nodeSeleccionado = node;
                tarjetasDisponibles = tarjetasFacade.findDisponibles();
                for (TarjetasVideo tarV : tarjetasDisponibles) {
                    contenedorHardware.setMarca(tarV.getIdMarca().getNombre());
                    contenedorHardware.setPuertos(tarV.getIdPuerto().getTipoPuerto());
                    contenedorHardware.setNumeroSerie(tarV.getNumeroSerial());
                    contenedorObj.add(contenedorHardware);
                }
            } else if (node == "Procesador") {
                nodeSeleccionado = node;
                procesadoresDisponibles = procesadoresFacade.findDisponibles();
                for (Procesadores proc : procesadoresDisponibles) {
                    contenedorHardware.setArquitectura(proc.getIdArquitectura().getArquitectura());
                    contenedorHardware.setModelo(proc.getIdModelo().getNombre());
                    contenedorHardware.setSocket(proc.getIdSocket().getSocket());
                    contenedorHardware.setNumeroSerie(proc.getNumeroSerie());
                    contenedorObj.add(contenedorHardware);
                }

            } else if (node == "Motherboard") {
                nodeSeleccionado = node;
                motherboardsDisponibles = motherboardsFacade.findDisponibles();
                for (Motherboards mother : motherboardsDisponibles) {
                    contenedorHardware.setMarca(mother.getIdMarca().getNombre());
                    contenedorHardware.setSocket(mother.getIdSocket().getSocket());
                    contenedorHardware.setNumeroSerie(mother.getNumeroSerie());
                    contenedorObj.add(contenedorHardware);
                }

            } else if (node == "Fuente de Voltaje") {
                nodeSeleccionado = node;
                fuentesDisponibles = fuentesFacade.findDisponibles();
                for (Fuentes source : fuentesDisponibles) {
                    contenedorHardware.setModelo(source.getIdModelo().getNombre());
                    contenedorHardware.setPotencia(source.getPotencia());
                    contenedorHardware.setNumeroSerie(source.getNumeroSerie());
                    contenedorObj.add(contenedorHardware);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*  public void limpiarListas() {
        discoDisp = new ArrayList<>();
        memoriasDisp = new ArrayList<>();
        procesadoresDisp = new ArrayList<>();
        motherDisp = new ArrayList<>();
        tarjetasDisp = new ArrayList<>();
        fuentesDisp = new ArrayList<>();
    }*/
    public void obtenerTodos() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            discoList = discosFacade.findAll();
            memoriasList = memoriasFacade.findAll();
            procesadoresList = procesadoresFacade.findAll();
            motherboardList = motherboardsFacade.findAll();
            tarjetasVideoList = tarjetasFacade.findAll();
            fuentesList = fuentesFacade.findAll();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }

// Obtener id de hardware seleccionado y guardarlo para utilizarlo para agregar el hw al componente
    public void hwSeleccionado(SelectEvent event) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        // System.out.println("Hardware seleccionado, NumeroSerie: " + ((contenedorObjetos) event.getObject()).getNumeroSerie()+" ID: "+((contenedorObjetos) event.getObject()).getId());
        try {
            if (nodeSeleccionado == "Discos") {
                contDisco = new Discos();
                contDisco.setIdDisco(((contenedorObjetos) event.getObject()).getId());
                // System.out.println(contDisco);
            }
            if (nodeSeleccionado == "Memorias") {
                contMemorias = new Memorias();
                contMemorias.setIdMemoria((((contenedorObjetos) event.getObject()).getId()));
            }
            if (nodeSeleccionado == "Procesadores") {
                contProcesadores = new Procesadores();
                contProcesadores.setIdProcesador((((contenedorObjetos) event.getObject()).getId()));
            }
            if (nodeSeleccionado == "Motherboard") {
                contMotherboards.setIdMotherboard((((contenedorObjetos) event.getObject()).getId()));
            }
            if (nodeSeleccionado == "Tarjetas de video") {
                contTarjetas = new TarjetasVideo();
                contTarjetas.setIdTarjetaVideo((((contenedorObjetos) event.getObject()).getId()));
            }
            if (nodeSeleccionado == "Fuentes") {
                contFuentes = new Fuentes();
                contFuentes.setIdFuente((((contenedorObjetos) event.getObject()).getId()));
            }

        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
            System.out.println(e);
        }

    }
//Asignar hardware a componente seleccionado

    public void agregarHardware() {
        boolean agregado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Fecha actual
        java.util.Date date = new java.util.Date();
        try {
            if (nodeSeleccionado == "Discos") {
                discosComponente.setIdDiscos(contDisco);
                discosComponente.setIdComponente(componenteSeleccionado);
                discosComponente.setEstado(true);
                discosComponente.setFechaAsignado(date);
                agregado = discoCompFacade.create(discosComponente);
                if (agregado) {
                    Discos discoSeleccionado = new Discos();
                    discoSeleccionado = discosFacade.find(contDisco.getIdDisco());
                    discoSeleccionado.setAsignado(true);
                    agregado = discosFacade.edit(discoSeleccionado);
                    contexto.addMessage(null, new FacesMessage("Registro guardado"));
                } else {
                    contexto.addMessage(null, new FacesMessage("No se pudo guardar el registro!"));
                }
                obtenerTodos();
            }

        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
            System.out.println(e);
        }
    }

   /* private String IdHwAsignado(TreeNode hardwareAsignado) {
        String string = hardwareAsignado.toString();
        String[] parts = string.split("-");
        String id = parts[0];
        return id;
    }*/
    
    
    public void inactivarHW() {
        boolean inactivado = false;
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            if (nodeSeleccionado=="Discos"){
                discoSeleccionado.setAsignado(false);
                inactivado = discosFacade.edit(discoSeleccionado);
            }
           if(inactivado){
               contexto.addMessage(null, new FacesMessage("Registro inactivado"));
           }else {
               contexto.addMessage(null, new FacesMessage("No se pudo inactivar el registro!"));
           }
           obtenerTodos();
        } catch (Exception e) {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", e.getMessage()));
        }
    }
}
