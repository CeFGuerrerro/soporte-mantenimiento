/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "discos", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discos.findAll", query = "SELECT d FROM Discos d")
    , @NamedQuery(name = "Discos.findByIdDisco", query = "SELECT d FROM Discos d WHERE d.idDisco = :idDisco")
    , @NamedQuery(name = "Discos.findByNumeroSerie", query = "SELECT d FROM Discos d WHERE d.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "Discos.findByEstado", query = "SELECT d FROM Discos d WHERE d.estado = :estado")
    , @NamedQuery(name = "Discos.findByAsignado", query = "SELECT d FROM Discos d WHERE d.asignado = :asignado")
    , @NamedQuery(name = "Discos.findByFechaDeBaja", query = "SELECT d FROM Discos d WHERE d.fechaDeBaja = :fechaDeBaja")
    , @NamedQuery(name = "Discos.findByObservaciones", query = "SELECT d FROM Discos d WHERE d.observaciones = :observaciones")})
public class Discos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disco", nullable = false)
    private Integer idDisco;
    @Column(name = "numero_serie", length = 2147483647)
    private String numeroSerie;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "asignado")
    private Boolean asignado;
    @Column(name = "fecha_de_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaDeBaja;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_capacidad", referencedColumnName = "id_capacidad")
    @ManyToOne
    private Capacidades idCapacidad;
    @JoinColumn(name = "id_dimension", referencedColumnName = "id_dimension")
    @ManyToOne
    private DimensionDisco idDimension;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @JoinColumn(name = "id_puerto", referencedColumnName = "id_puerto")
    @ManyToOne
    private Puertos idPuerto;
    @JoinColumn(name = "id_tipo_disco", referencedColumnName = "id_tipo_disco")
    @ManyToOne
    private TiposDisco idTipoDisco;

    public Discos() {
    }

    public Discos(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
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

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public Date getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(Date fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Capacidades getIdCapacidad() {
        return idCapacidad;
    }

    public void setIdCapacidad(Capacidades idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public DimensionDisco getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(DimensionDisco idDimension) {
        this.idDimension = idDimension;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Puertos getIdPuerto() {
        return idPuerto;
    }

    public void setIdPuerto(Puertos idPuerto) {
        this.idPuerto = idPuerto;
    }

    public TiposDisco getIdTipoDisco() {
        return idTipoDisco;
    }

    public void setIdTipoDisco(TiposDisco idTipoDisco) {
        this.idTipoDisco = idTipoDisco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisco != null ? idDisco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discos)) {
            return false;
        }
        Discos other = (Discos) object;
        if ((this.idDisco == null && other.idDisco != null) || (this.idDisco != null && !this.idDisco.equals(other.idDisco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Discos[ idDisco=" + idDisco + " ]";
    }
    
}
