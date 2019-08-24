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
@Table(name = "discos_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiscosComponente.findAll", query = "SELECT d FROM DiscosComponente d")
    , @NamedQuery(name = "DiscosComponente.findByIdDiscosComponente", query = "SELECT d FROM DiscosComponente d WHERE d.idDiscosComponente = :idDiscosComponente")
    , @NamedQuery(name = "DiscosComponente.findByFechaAsignado", query = "SELECT d FROM DiscosComponente d WHERE d.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "DiscosComponente.findByFechaCambio", query = "SELECT d FROM DiscosComponente d WHERE d.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "DiscosComponente.findByEstado", query = "SELECT d FROM DiscosComponente d WHERE d.estado = :estado")
    , @NamedQuery(name = "DiscosComponente.findByObservaciones", query = "SELECT d FROM DiscosComponente d WHERE d.observaciones = :observaciones")})
public class DiscosComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discos_componente", nullable = false)
    private Integer idDiscosComponente;
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
    @JoinColumn(name = "id_discos", referencedColumnName = "id_disco")
    @ManyToOne
    private Discos idDiscos;

    public DiscosComponente() {
    }

    public DiscosComponente(Integer idDiscosComponente) {
        this.idDiscosComponente = idDiscosComponente;
    }

    public Integer getIdDiscosComponente() {
        return idDiscosComponente;
    }

    public void setIdDiscosComponente(Integer idDiscosComponente) {
        this.idDiscosComponente = idDiscosComponente;
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

    public Discos getIdDiscos() {
        return idDiscos;
    }

    public void setIdDiscos(Discos idDiscos) {
        this.idDiscos = idDiscos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscosComponente != null ? idDiscosComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscosComponente)) {
            return false;
        }
        DiscosComponente other = (DiscosComponente) object;
        if ((this.idDiscosComponente == null && other.idDiscosComponente != null) || (this.idDiscosComponente != null && !this.idDiscosComponente.equals(other.idDiscosComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.DiscosComponente[ idDiscosComponente=" + idDiscosComponente + " ]";
    }
    
}
