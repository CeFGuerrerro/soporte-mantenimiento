/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "permisos", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdPermiso", query = "SELECT p FROM Permisos p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "Permisos.findByArquitectura", query = "SELECT p FROM Permisos p WHERE p.arquitectura = :arquitectura")
    , @NamedQuery(name = "Permisos.findByComponentes", query = "SELECT p FROM Permisos p WHERE p.componentes = :componentes")
    , @NamedQuery(name = "Permisos.findByCronograma", query = "SELECT p FROM Permisos p WHERE p.cronograma = :cronograma")
    , @NamedQuery(name = "Permisos.findByEquipos", query = "SELECT p FROM Permisos p WHERE p.equipos = :equipos")
    , @NamedQuery(name = "Permisos.findByMantenimiento", query = "SELECT p FROM Permisos p WHERE p.mantenimiento = :mantenimiento")
    , @NamedQuery(name = "Permisos.findByMarcas", query = "SELECT p FROM Permisos p WHERE p.marcas = :marcas")
    , @NamedQuery(name = "Permisos.findByModelos", query = "SELECT p FROM Permisos p WHERE p.modelos = :modelos")
    , @NamedQuery(name = "Permisos.findByHardware", query = "SELECT p FROM Permisos p WHERE p.hardware = :hardware")
    , @NamedQuery(name = "Permisos.findBySoftware", query = "SELECT p FROM Permisos p WHERE p.software = :software")
    , @NamedQuery(name = "Permisos.findBySoftwareComponente", query = "SELECT p FROM Permisos p WHERE p.softwareComponente = :softwareComponente")
    , @NamedQuery(name = "Permisos.findByHardwareComponente", query = "SELECT p FROM Permisos p WHERE p.hardwareComponente = :hardwareComponente")
    , @NamedQuery(name = "Permisos.findByResponsables", query = "SELECT p FROM Permisos p WHERE p.responsables = :responsables")
    , @NamedQuery(name = "Permisos.findBySolicitudes", query = "SELECT p FROM Permisos p WHERE p.solicitudes = :solicitudes")
    , @NamedQuery(name = "Permisos.findBySoluciones", query = "SELECT p FROM Permisos p WHERE p.soluciones = :soluciones")
    , @NamedQuery(name = "Permisos.findByTecnicos", query = "SELECT p FROM Permisos p WHERE p.tecnicos = :tecnicos")
    , @NamedQuery(name = "Permisos.findByUbicaciones", query = "SELECT p FROM Permisos p WHERE p.ubicaciones = :ubicaciones")
    , @NamedQuery(name = "Permisos.findByOrdenTrabajo", query = "SELECT p FROM Permisos p WHERE p.ordenTrabajo = :ordenTrabajo")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso", nullable = false)
    private Integer idPermiso;
    @Column(name = "arquitectura")
    private Boolean arquitectura;
    @Column(name = "componentes")
    private Boolean componentes;
    @Column(name = "cronograma")
    private Boolean cronograma;
    @Column(name = "equipos")
    private Boolean equipos;
    @Column(name = "mantenimiento")
    private Boolean mantenimiento;
    @Column(name = "marcas")
    private Boolean marcas;
    @Column(name = "modelos")
    private Boolean modelos;
    @Column(name = "hardware")
    private Boolean hardware;
    @Column(name = "software")
    private Boolean software;
    @Column(name = "software_componente")
    private Boolean softwareComponente;
    @Column(name = "hardware_componente")
    private Boolean hardwareComponente;
    @Column(name = "responsables")
    private Boolean responsables;
    @Column(name = "solicitudes")
    private Boolean solicitudes;
    @Column(name = "soluciones")
    private Boolean soluciones;
    @Column(name = "tecnicos")
    private Boolean tecnicos;
    @Column(name = "ubicaciones")
    private Boolean ubicaciones;
    @Column(name = "orden_trabajo")
    private Boolean ordenTrabajo;
    @JoinColumn(name = "id_loggin", referencedColumnName = "id_loggin", nullable = false)
    @ManyToOne(optional = false)
    private Loggin idLoggin;

    public Permisos() {
    }

    public Permisos(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Boolean getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(Boolean arquitectura) {
        this.arquitectura = arquitectura;
    }

    public Boolean getComponentes() {
        return componentes;
    }

    public void setComponentes(Boolean componentes) {
        this.componentes = componentes;
    }

    public Boolean getCronograma() {
        return cronograma;
    }

    public void setCronograma(Boolean cronograma) {
        this.cronograma = cronograma;
    }

    public Boolean getEquipos() {
        return equipos;
    }

    public void setEquipos(Boolean equipos) {
        this.equipos = equipos;
    }

    public Boolean getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Boolean getMarcas() {
        return marcas;
    }

    public void setMarcas(Boolean marcas) {
        this.marcas = marcas;
    }

    public Boolean getModelos() {
        return modelos;
    }

    public void setModelos(Boolean modelos) {
        this.modelos = modelos;
    }

    public Boolean getHardware() {
        return hardware;
    }

    public void setHardware(Boolean hardware) {
        this.hardware = hardware;
    }

    public Boolean getSoftware() {
        return software;
    }

    public void setSoftware(Boolean software) {
        this.software = software;
    }

    public Boolean getSoftwareComponente() {
        return softwareComponente;
    }

    public void setSoftwareComponente(Boolean softwareComponente) {
        this.softwareComponente = softwareComponente;
    }

    public Boolean getHardwareComponente() {
        return hardwareComponente;
    }

    public void setHardwareComponente(Boolean hardwareComponente) {
        this.hardwareComponente = hardwareComponente;
    }

    public Boolean getResponsables() {
        return responsables;
    }

    public void setResponsables(Boolean responsables) {
        this.responsables = responsables;
    }

    public Boolean getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Boolean solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Boolean getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(Boolean soluciones) {
        this.soluciones = soluciones;
    }

    public Boolean getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Boolean tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Boolean getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(Boolean ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public Boolean getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(Boolean ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Loggin getIdLoggin() {
        return idLoggin;
    }

    public void setIdLoggin(Loggin idLoggin) {
        this.idLoggin = idLoggin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Permisos[ idPermiso=" + idPermiso + " ]";
    }
    
}
