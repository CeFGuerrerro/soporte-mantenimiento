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
@Table(name = "tipos_solicitud", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposSolicitud.findAll", query = "SELECT t FROM TiposSolicitud t")
    , @NamedQuery(name = "TiposSolicitud.findByIdTipoSolicitud", query = "SELECT t FROM TiposSolicitud t WHERE t.idTipoSolicitud = :idTipoSolicitud")
    , @NamedQuery(name = "TiposSolicitud.findByNombre", query = "SELECT t FROM TiposSolicitud t WHERE t.nombre = :nombre")})
public class TiposSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_solicitud", nullable = false)
    private Integer idTipoSolicitud;
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    @OneToMany(mappedBy = "idTipoSolicitud")
    private List<Solicitudes> solicitudesList;

    public TiposSolicitud() {
    }

    public TiposSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposSolicitud)) {
            return false;
        }
        TiposSolicitud other = (TiposSolicitud) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposSolicitud[ idTipoSolicitud=" + idTipoSolicitud + " ]";
    }
    
}
