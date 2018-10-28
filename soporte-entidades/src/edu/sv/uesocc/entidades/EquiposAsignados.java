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
@Table(name = "equipos_asignados", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquiposAsignados.findAll", query = "SELECT e FROM EquiposAsignados e")
    , @NamedQuery(name = "EquiposAsignados.findByIdEquipoAsignado", query = "SELECT e FROM EquiposAsignados e WHERE e.idEquipoAsignado = :idEquipoAsignado")
    , @NamedQuery(name = "EquiposAsignados.findByFecha", query = "SELECT e FROM EquiposAsignados e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "EquiposAsignados.findByObservaciones", query = "SELECT e FROM EquiposAsignados e WHERE e.observaciones = :observaciones")})
public class EquiposAsignados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo_asignado", nullable = false)
    private Integer idEquipoAsignado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipos idEquipo;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable", nullable = false)
    @ManyToOne(optional = false)
    private Resposables idResponsable;

    public EquiposAsignados() {
    }

    public EquiposAsignados(Integer idEquipoAsignado) {
        this.idEquipoAsignado = idEquipoAsignado;
    }

    public Integer getIdEquipoAsignado() {
        return idEquipoAsignado;
    }

    public void setIdEquipoAsignado(Integer idEquipoAsignado) {
        this.idEquipoAsignado = idEquipoAsignado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Resposables getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Resposables idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoAsignado != null ? idEquipoAsignado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquiposAsignados)) {
            return false;
        }
        EquiposAsignados other = (EquiposAsignados) object;
        if ((this.idEquipoAsignado == null && other.idEquipoAsignado != null) || (this.idEquipoAsignado != null && !this.idEquipoAsignado.equals(other.idEquipoAsignado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.EquiposAsignados[ idEquipoAsignado=" + idEquipoAsignado + " ]";
    }
    
}
