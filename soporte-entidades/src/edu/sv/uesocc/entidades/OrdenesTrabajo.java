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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "ordenes_trabajo", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesTrabajo.findAll", query = "SELECT o FROM OrdenesTrabajo o")
    , @NamedQuery(name = "OrdenesTrabajo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenesTrabajo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenesTrabajo.findByPrioridad", query = "SELECT o FROM OrdenesTrabajo o WHERE o.prioridad = :prioridad")
    , @NamedQuery(name = "OrdenesTrabajo.findByFechaInicio", query = "SELECT o FROM OrdenesTrabajo o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "OrdenesTrabajo.findByFechaFinalizacion", query = "SELECT o FROM OrdenesTrabajo o WHERE o.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "OrdenesTrabajo.findByHoraInicio", query = "SELECT o FROM OrdenesTrabajo o WHERE o.horaInicio = :horaInicio")
    , @NamedQuery(name = "OrdenesTrabajo.findByHoraFinalizacion", query = "SELECT o FROM OrdenesTrabajo o WHERE o.horaFinalizacion = :horaFinalizacion")
    , @NamedQuery(name = "OrdenesTrabajo.findByObservaciones", query = "SELECT o FROM OrdenesTrabajo o WHERE o.observaciones = :observaciones")})
public class OrdenesTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo", nullable = false)
    private Integer idOrdenTrabajo;
    @Column(name = "prioridad", length = 2147483647)
    private String prioridad;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Column(name = "hora_inicio", length = 2147483647)
    private String horaInicio;
    @Column(name = "hora_finalizacion", length = 2147483647)
    private String horaFinalizacion;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenTrabajo")
    private List<DetallesOrdenTrabajo> detallesOrdenTrabajoList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private EstadosOrden idEstado;
    @JoinColumn(name = "id_mantenimiento", referencedColumnName = "id_mantenimiento", nullable = false)
    @ManyToOne(optional = false)
    private Mantenimientos idMantenimiento;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitudes idSolicitud;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico", nullable = false)
    @ManyToOne(optional = false)
    private Tecnicos idTecnico;

    public OrdenesTrabajo() {
    }

    public OrdenesTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<DetallesOrdenTrabajo> getDetallesOrdenTrabajoList() {
        return detallesOrdenTrabajoList;
    }

    public void setDetallesOrdenTrabajoList(List<DetallesOrdenTrabajo> detallesOrdenTrabajoList) {
        this.detallesOrdenTrabajoList = detallesOrdenTrabajoList;
    }

    public EstadosOrden getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadosOrden idEstado) {
        this.idEstado = idEstado;
    }

    public Mantenimientos getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Mantenimientos idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Solicitudes getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitudes idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Tecnicos getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnicos idTecnico) {
        this.idTecnico = idTecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesTrabajo)) {
            return false;
        }
        OrdenesTrabajo other = (OrdenesTrabajo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.OrdenesTrabajo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
