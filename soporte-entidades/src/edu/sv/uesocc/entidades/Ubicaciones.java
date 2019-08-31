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
@Table(name = "ubicaciones", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u")
    , @NamedQuery(name = "Ubicaciones.findByIdUbicacion", query = "SELECT u FROM Ubicaciones u WHERE u.idUbicacion = :idUbicacion")
    , @NamedQuery(name = "Ubicaciones.findByNombre", query = "SELECT u FROM Ubicaciones u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Ubicaciones.findByDescripcion", query = "SELECT u FROM Ubicaciones u WHERE u.descripcion = :descripcion")})
public class Ubicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ubicacion", nullable = false)
    private Integer idUbicacion;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbicacion")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbicacion")
    private List<Solicitudes> solicitudesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbicacion")
    private List<Equipos> equiposList;
    @OneToMany(mappedBy = "idUbicacion")
    private List<Responsables> responsablesList;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicaciones(Integer idUbicacion, String nombre) {
        this.idUbicacion = idUbicacion;
        this.nombre = nombre;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
    }

    @XmlTransient
    public List<Responsables> getResponsablesList() {
        return responsablesList;
    }

    public void setResponsablesList(List<Responsables> responsablesList) {
        this.responsablesList = responsablesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacion != null ? idUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.idUbicacion == null && other.idUbicacion != null) || (this.idUbicacion != null && !this.idUbicacion.equals(other.idUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Ubicaciones[ idUbicacion=" + idUbicacion + " ]";
    }
    
}
