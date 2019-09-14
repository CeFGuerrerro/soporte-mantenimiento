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
@Table(name = "cronograma", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cronograma.findAll", query = "SELECT c FROM Cronograma c")
    , @NamedQuery(name = "Cronograma.findByIdCronograma", query = "SELECT c FROM Cronograma c WHERE c.idCronograma = :idCronograma")
    , @NamedQuery(name = "Cronograma.findByFechaInicio", query = "SELECT c FROM Cronograma c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Cronograma.findByFechaFin", query = "SELECT c FROM Cronograma c WHERE c.fechaFin = :fechaFin")
    , @NamedQuery(name = "Cronograma.findByNombreEvento", query = "SELECT c FROM Cronograma c WHERE c.nombreEvento = :nombreEvento")
    , @NamedQuery(name = "Cronograma.findByDescripcion", query = "SELECT c FROM Cronograma c WHERE c.descripcion = :descripcion")})
public class Cronograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cronograma", nullable = false)
    private Integer idCronograma;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "nombre_evento", nullable = false, length = 2147483647)
    private String nombreEvento;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne
    private OrdenesTrabajo idOrdenTrabajo;

    public Cronograma() {
    }

    public Cronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Cronograma(Integer idCronograma, Date fechaInicio, Date fechaFin, String nombreEvento) {
        this.idCronograma = idCronograma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreEvento = nombreEvento;
    }

    public Integer getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OrdenesTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenesTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCronograma != null ? idCronograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.idCronograma == null && other.idCronograma != null) || (this.idCronograma != null && !this.idCronograma.equals(other.idCronograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Cronograma[ idCronograma=" + idCronograma + " ]";
    }
    
}
