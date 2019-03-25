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
@Table(name = "responsables", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsables.findAll", query = "SELECT r FROM Responsables r")
    , @NamedQuery(name = "Responsables.findByIdResponsable", query = "SELECT r FROM Responsables r WHERE r.idResponsable = :idResponsable")
    , @NamedQuery(name = "Responsables.findByNombre", query = "SELECT r FROM Responsables r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Responsables.findByCorreo", query = "SELECT r FROM Responsables r WHERE r.correo = :correo")})
public class Responsables implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsable")
    private List<Solicitudes> solicitudesList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_responsable", nullable = false)
    private Integer idResponsable;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "correo", length = 2147483647)
    private String correo;
    @OneToMany(mappedBy = "idResponsable")
    private List<Equipos> equiposList;
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    @ManyToOne
    private Ubicaciones idUbicacion;

    public Responsables() {
    }

    public Responsables(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Responsables(Integer idResponsable, String nombre) {
        this.idResponsable = idResponsable;
        this.nombre = nombre;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
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
        hash += (idResponsable != null ? idResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsables)) {
            return false;
        }
        Responsables other = (Responsables) object;
        if ((this.idResponsable == null && other.idResponsable != null) || (this.idResponsable != null && !this.idResponsable.equals(other.idResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Responsables[ idResponsable=" + idResponsable + " ]";
    }

    @XmlTransient
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }
    
}
