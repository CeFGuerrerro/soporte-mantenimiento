/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estados_solicitud", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosSolicitud.findAll", query = "SELECT e FROM EstadosSolicitud e")
    , @NamedQuery(name = "EstadosSolicitud.findByIdEstado", query = "SELECT e FROM EstadosSolicitud e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadosSolicitud.findByNombre", query = "SELECT e FROM EstadosSolicitud e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EstadosSolicitud.findByDescripcion", query = "SELECT e FROM EstadosSolicitud e WHERE e.descripcion = :descripcion")})
public class EstadosSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(mappedBy = "idEstado")
    private List<Solicitudes> solicitudesList;

    public EstadosSolicitud() {
    }

    public EstadosSolicitud(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadosSolicitud(Integer idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
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
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosSolicitud)) {
            return false;
        }
        EstadosSolicitud other = (EstadosSolicitud) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.EstadosSolicitud[ idEstado=" + idEstado + " ]";
    }
    
}
