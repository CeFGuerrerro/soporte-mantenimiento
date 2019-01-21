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
@Table(name = "componentes_equipo", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComponentesEquipo.findAll", query = "SELECT c FROM ComponentesEquipo c")
    , @NamedQuery(name = "ComponentesEquipo.findByIdComponenteEquipo", query = "SELECT c FROM ComponentesEquipo c WHERE c.idComponenteEquipo = :idComponenteEquipo")
    , @NamedQuery(name = "ComponentesEquipo.findByFechaVinculado", query = "SELECT c FROM ComponentesEquipo c WHERE c.fechaVinculado = :fechaVinculado")
    , @NamedQuery(name = "ComponentesEquipo.findByFechaDesvinculado", query = "SELECT c FROM ComponentesEquipo c WHERE c.fechaDesvinculado = :fechaDesvinculado")
    , @NamedQuery(name = "ComponentesEquipo.findByEstado", query = "SELECT c FROM ComponentesEquipo c WHERE c.estado = :estado")
    , @NamedQuery(name = "ComponentesEquipo.findByObservaciones", query = "SELECT c FROM ComponentesEquipo c WHERE c.observaciones = :observaciones")})
public class ComponentesEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente_equipo", nullable = false)
    private Integer idComponenteEquipo;
    @Column(name = "fecha_vinculado")
    @Temporal(TemporalType.DATE)
    private Date fechaVinculado;
    @Column(name = "fecha_desvinculado")
    @Temporal(TemporalType.DATE)
    private Date fechaDesvinculado;
    @Column(name = "estado")
    private Boolean estado = true;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente", nullable = false)
    @ManyToOne(optional = false)
    private Componentes idComponente;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipos idEquipo;

    public ComponentesEquipo() {
    }

    public ComponentesEquipo(Integer idComponenteEquipo) {
        this.idComponenteEquipo = idComponenteEquipo;
    }

    public Integer getIdComponenteEquipo() {
        return idComponenteEquipo;
    }

    public void setIdComponenteEquipo(Integer idComponenteEquipo) {
        this.idComponenteEquipo = idComponenteEquipo;
    }

    public Date getFechaVinculado() {
        return fechaVinculado;
    }

    public void setFechaVinculado(Date fechaVinculado) {
        this.fechaVinculado = fechaVinculado;
    }

    public Date getFechaDesvinculado() {
        return fechaDesvinculado;
    }

    public void setFechaDesvinculado(Date fechaDesvinculado) {
        this.fechaDesvinculado = fechaDesvinculado;
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

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponenteEquipo != null ? idComponenteEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponentesEquipo)) {
            return false;
        }
        ComponentesEquipo other = (ComponentesEquipo) object;
        if ((this.idComponenteEquipo == null && other.idComponenteEquipo != null) || (this.idComponenteEquipo != null && !this.idComponenteEquipo.equals(other.idComponenteEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.ComponentesEquipo[ idComponenteEquipo=" + idComponenteEquipo + " ]";
    }
    
}
