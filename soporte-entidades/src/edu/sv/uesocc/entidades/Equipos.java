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
@Table(name = "equipos", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipos.findByEstado", query = "SELECT e FROM Equipos e WHERE e.estado = :estado")
    , @NamedQuery(name = "Equipos.findByObservaciones", query = "SELECT e FROM Equipos e WHERE e.observaciones = :observaciones")})
public class Equipos implements Serializable {

    @Column(name = "obsevaciones", length = 2147483647)
    private String obsevaciones;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsables idResponsable;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<Solicitudes> solicitudesList;
    @OneToMany(mappedBy = "idEquipo")
    private List<Componentes> componentesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<Cronograma> cronogramaList;
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion", nullable = false)
    @ManyToOne(optional = false)
    private Ubicaciones idUbicacion;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsables idResponsable;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
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

    @XmlTransient
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    @XmlTransient
    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }

    @XmlTransient
    public List<Cronograma> getCronogramaList() {
        return cronogramaList;
    }

    public void setCronogramaList(List<Cronograma> cronogramaList) {
        this.cronogramaList = cronogramaList;
    }

    public Ubicaciones getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicaciones idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Equipos[ idEquipo=" + idEquipo + " ]";
    }

    public String getObsevaciones() {
        return obsevaciones;
    }

    public void setObsevaciones(String obsevaciones) {
        this.obsevaciones = obsevaciones;
    }

    public Responsables getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsables idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    public Responsables getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsables idResponsable) {
        this.idResponsable = idResponsable;
    }

}
