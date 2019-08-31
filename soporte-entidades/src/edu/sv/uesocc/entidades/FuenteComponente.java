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
@Table(name = "fuente_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuenteComponente.findAll", query = "SELECT f FROM FuenteComponente f")
    , @NamedQuery(name = "FuenteComponente.findByIdFuenteComponente", query = "SELECT f FROM FuenteComponente f WHERE f.idFuenteComponente = :idFuenteComponente")
    , @NamedQuery(name = "FuenteComponente.findByFechaAsignado", query = "SELECT f FROM FuenteComponente f WHERE f.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "FuenteComponente.findByFechaCambio", query = "SELECT f FROM FuenteComponente f WHERE f.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "FuenteComponente.findByEstado", query = "SELECT f FROM FuenteComponente f WHERE f.estado = :estado")
    , @NamedQuery(name = "FuenteComponente.findByObservaciones", query = "SELECT f FROM FuenteComponente f WHERE f.observaciones = :observaciones")})
public class FuenteComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fuente_componente", nullable = false)
    private Integer idFuenteComponente;
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
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componentes idComponente;
    @JoinColumn(name = "id_fuente", referencedColumnName = "id_fuente")
    @ManyToOne
    private Fuentes idFuente;

    public FuenteComponente() {
    }

    public FuenteComponente(Integer idFuenteComponente) {
        this.idFuenteComponente = idFuenteComponente;
    }

    public Integer getIdFuenteComponente() {
        return idFuenteComponente;
    }

    public void setIdFuenteComponente(Integer idFuenteComponente) {
        this.idFuenteComponente = idFuenteComponente;
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

    public Componentes getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componentes idComponente) {
        this.idComponente = idComponente;
    }

    public Fuentes getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Fuentes idFuente) {
        this.idFuente = idFuente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuenteComponente != null ? idFuenteComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuenteComponente)) {
            return false;
        }
        FuenteComponente other = (FuenteComponente) object;
        if ((this.idFuenteComponente == null && other.idFuenteComponente != null) || (this.idFuenteComponente != null && !this.idFuenteComponente.equals(other.idFuenteComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.FuenteComponente[ idFuenteComponente=" + idFuenteComponente + " ]";
    }
    
}
