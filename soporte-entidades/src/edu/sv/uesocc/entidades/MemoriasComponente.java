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
@Table(name = "memorias_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemoriasComponente.findAll", query = "SELECT m FROM MemoriasComponente m")
    , @NamedQuery(name = "MemoriasComponente.findByIdMemoriasComponente", query = "SELECT m FROM MemoriasComponente m WHERE m.idMemoriasComponente = :idMemoriasComponente")
    , @NamedQuery(name = "MemoriasComponente.findByFechaAsignado", query = "SELECT m FROM MemoriasComponente m WHERE m.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "MemoriasComponente.findByFechaCambio", query = "SELECT m FROM MemoriasComponente m WHERE m.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "MemoriasComponente.findByEstado", query = "SELECT m FROM MemoriasComponente m WHERE m.estado = :estado")
    , @NamedQuery(name = "MemoriasComponente.findByObservaciones", query = "SELECT m FROM MemoriasComponente m WHERE m.observaciones = :observaciones")})
public class MemoriasComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_memorias_componente", nullable = false)
    private Integer idMemoriasComponente;
    @Column(name = "fecha_asignado")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignado;
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_memoria", referencedColumnName = "id_memoria")
    @ManyToOne
    private Memorias idMemoria;

    public MemoriasComponente() {
    }

    public MemoriasComponente(Integer idMemoriasComponente) {
        this.idMemoriasComponente = idMemoriasComponente;
    }

    public Integer getIdMemoriasComponente() {
        return idMemoriasComponente;
    }

    public void setIdMemoriasComponente(Integer idMemoriasComponente) {
        this.idMemoriasComponente = idMemoriasComponente;
    }

    public Date getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(Date fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Memorias getIdMemoria() {
        return idMemoria;
    }

    public void setIdMemoria(Memorias idMemoria) {
        this.idMemoria = idMemoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMemoriasComponente != null ? idMemoriasComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemoriasComponente)) {
            return false;
        }
        MemoriasComponente other = (MemoriasComponente) object;
        if ((this.idMemoriasComponente == null && other.idMemoriasComponente != null) || (this.idMemoriasComponente != null && !this.idMemoriasComponente.equals(other.idMemoriasComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.MemoriasComponente[ idMemoriasComponente=" + idMemoriasComponente + " ]";
    }
    
}
