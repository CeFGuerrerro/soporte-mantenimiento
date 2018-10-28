/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "componentes", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componentes.findAll", query = "SELECT c FROM Componentes c")
    , @NamedQuery(name = "Componentes.findByIdComponente", query = "SELECT c FROM Componentes c WHERE c.idComponente = :idComponente")
    , @NamedQuery(name = "Componentes.findByNumeroInventario", query = "SELECT c FROM Componentes c WHERE c.numeroInventario = :numeroInventario")
    , @NamedQuery(name = "Componentes.findByNumeroSerie", query = "SELECT c FROM Componentes c WHERE c.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "Componentes.findByEstado", query = "SELECT c FROM Componentes c WHERE c.estado = :estado")
    , @NamedQuery(name = "Componentes.findByPersonal", query = "SELECT c FROM Componentes c WHERE c.personal = :personal")
    , @NamedQuery(name = "Componentes.findByAsignado", query = "SELECT c FROM Componentes c WHERE c.asignado = :asignado")
    , @NamedQuery(name = "Componentes.findByObservaciones", query = "SELECT c FROM Componentes c WHERE c.observaciones = :observaciones")})
public class Componentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente", nullable = false)
    private Integer idComponente;
    @Column(name = "numero_inventario", length = 2147483647)
    private String numeroInventario;
    @Column(name = "numero_serie", length = 2147483647)
    private String numeroSerie;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "personal")
    private Boolean personal;
    @Column(name = "asignado")
    private Boolean asignado;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipos idEquipo;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelos idModelo;
    @JoinColumn(name = "id_tipo_componente", referencedColumnName = "id_tipo_componente", nullable = false)
    @ManyToOne(optional = false)
    private TiposComponente idTipoComponente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente")
    private List<SoftwareComponente> softwareComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente")
    private List<HardwareComponente> hardwareComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente")
    private List<Ups> upsList;

    public Componentes() {
    }

    public Componentes(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    public TiposComponente getIdTipoComponente() {
        return idTipoComponente;
    }

    public void setIdTipoComponente(TiposComponente idTipoComponente) {
        this.idTipoComponente = idTipoComponente;
    }

    @XmlTransient
    public List<SoftwareComponente> getSoftwareComponenteList() {
        return softwareComponenteList;
    }

    public void setSoftwareComponenteList(List<SoftwareComponente> softwareComponenteList) {
        this.softwareComponenteList = softwareComponenteList;
    }

    @XmlTransient
    public List<HardwareComponente> getHardwareComponenteList() {
        return hardwareComponenteList;
    }

    public void setHardwareComponenteList(List<HardwareComponente> hardwareComponenteList) {
        this.hardwareComponenteList = hardwareComponenteList;
    }

    @XmlTransient
    public List<Ups> getUpsList() {
        return upsList;
    }

    public void setUpsList(List<Ups> upsList) {
        this.upsList = upsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componentes)) {
            return false;
        }
        Componentes other = (Componentes) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Componentes[ idComponente=" + idComponente + " ]";
    }
    
}
