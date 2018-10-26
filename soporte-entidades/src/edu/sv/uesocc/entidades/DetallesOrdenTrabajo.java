/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "detalles_orden_trabajo", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesOrdenTrabajo.findAll", query = "SELECT d FROM DetallesOrdenTrabajo d")
    , @NamedQuery(name = "DetallesOrdenTrabajo.findByIdDetalle", query = "SELECT d FROM DetallesOrdenTrabajo d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetallesOrdenTrabajo.findByObservaciones", query = "SELECT d FROM DetallesOrdenTrabajo d WHERE d.observaciones = :observaciones")})
public class DetallesOrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle", nullable = false)
    private Integer idDetalle;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private OrdenesTrabajo idOrdenTrabajo;
    @JoinColumn(name = "id_solucion", referencedColumnName = "id_solucion", nullable = false)
    @ManyToOne(optional = false)
    private Soluciones idSolucion;
    @JoinColumn(name = "id_tipo_mantenimiento", referencedColumnName = "id_tipo_mantenimiento", nullable = false)
    @ManyToOne(optional = false)
    private TiposMantenimiento idTipoMantenimiento;

    public DetallesOrdenTrabajo() {
    }

    public DetallesOrdenTrabajo(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrdenesTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenesTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Soluciones getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(Soluciones idSolucion) {
        this.idSolucion = idSolucion;
    }

    public TiposMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TiposMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesOrdenTrabajo)) {
            return false;
        }
        DetallesOrdenTrabajo other = (DetallesOrdenTrabajo) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.DetallesOrdenTrabajo[ idDetalle=" + idDetalle + " ]";
    }
    
}
