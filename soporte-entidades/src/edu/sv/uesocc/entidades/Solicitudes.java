/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "solicitudes", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudes.findAll", query = "SELECT s FROM Solicitudes s")
    , @NamedQuery(name = "Solicitudes.findByIdSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitudes.findByFechaSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Solicitudes.findByProblema", query = "SELECT s FROM Solicitudes s WHERE s.problema = :problema")
    , @NamedQuery(name = "Solicitudes.findByCodigoSeguimiento", query = "SELECT s FROM Solicitudes s WHERE s.codigoSeguimiento = :codigoSeguimiento")
    , @NamedQuery(name = "Solicitudes.findByEstado", query = "SELECT s FROM Solicitudes s WHERE s.estado = :estado")})
public class Solicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud", nullable = false)
    private Integer idSolicitud;
    @Basic(optional = false)
    @Column(name = "fecha_solicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @Column(name = "problema", nullable = false, length = 2147483647)
    private String problema;
    @Column(name = "codigo_seguimiento")
    private Integer codigoSeguimiento;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable", nullable = false)
    @ManyToOne(optional = false)
    private Responsables idResponsable;
    @JoinColumn(name = "id_tipo_solicitud", referencedColumnName = "id_tipo_solicitud", nullable = false)
    @ManyToOne(optional = false)
    private TiposSolicitud idTipoSolicitud;
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion", nullable = false)
    @ManyToOne(optional = false)
    private Ubicaciones idUbicacion;
    @OneToMany(mappedBy = "idSolicitud")
    private List<OrdenesTrabajo> ordenesTrabajoList;

    public Solicitudes() {
    }

    public Solicitudes(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitudes(Integer idSolicitud, Date fechaSolicitud, String problema) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.problema = problema;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Integer getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(Integer codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Responsables getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsables idResponsable) {
        this.idResponsable = idResponsable;
    }

    public TiposSolicitud getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(TiposSolicitud idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Ubicaciones getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicaciones idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    @XmlTransient
    public List<OrdenesTrabajo> getOrdenesTrabajoList() {
        return ordenesTrabajoList;
    }

    public void setOrdenesTrabajoList(List<OrdenesTrabajo> ordenesTrabajoList) {
        this.ordenesTrabajoList = ordenesTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudes)) {
            return false;
        }
        Solicitudes other = (Solicitudes) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Solicitudes[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
