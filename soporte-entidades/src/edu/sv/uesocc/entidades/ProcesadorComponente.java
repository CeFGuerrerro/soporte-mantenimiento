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
@Table(name = "procesador_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesadorComponente.findAll", query = "SELECT p FROM ProcesadorComponente p")
    , @NamedQuery(name = "ProcesadorComponente.findByIdProcesadorComponente", query = "SELECT p FROM ProcesadorComponente p WHERE p.idProcesadorComponente = :idProcesadorComponente")
    , @NamedQuery(name = "ProcesadorComponente.findByFechaAsignado", query = "SELECT p FROM ProcesadorComponente p WHERE p.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "ProcesadorComponente.findByFechaCambio", query = "SELECT p FROM ProcesadorComponente p WHERE p.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "ProcesadorComponente.findByEstado", query = "SELECT p FROM ProcesadorComponente p WHERE p.estado = :estado")
    , @NamedQuery(name = "ProcesadorComponente.findByObservaciones", query = "SELECT p FROM ProcesadorComponente p WHERE p.observaciones = :observaciones")})
public class ProcesadorComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procesador_componente", nullable = false)
    private Integer idProcesadorComponente;
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
    @JoinColumn(name = "id_procesador", referencedColumnName = "id_procesador")
    @ManyToOne
    private Procesadores idProcesador;

    public ProcesadorComponente() {
    }

    public ProcesadorComponente(Integer idProcesadorComponente) {
        this.idProcesadorComponente = idProcesadorComponente;
    }

    public Integer getIdProcesadorComponente() {
        return idProcesadorComponente;
    }

    public void setIdProcesadorComponente(Integer idProcesadorComponente) {
        this.idProcesadorComponente = idProcesadorComponente;
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

    public Procesadores getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Procesadores idProcesador) {
        this.idProcesador = idProcesador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesadorComponente != null ? idProcesadorComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesadorComponente)) {
            return false;
        }
        ProcesadorComponente other = (ProcesadorComponente) object;
        if ((this.idProcesadorComponente == null && other.idProcesadorComponente != null) || (this.idProcesadorComponente != null && !this.idProcesadorComponente.equals(other.idProcesadorComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.ProcesadorComponente[ idProcesadorComponente=" + idProcesadorComponente + " ]";
    }
    
}
