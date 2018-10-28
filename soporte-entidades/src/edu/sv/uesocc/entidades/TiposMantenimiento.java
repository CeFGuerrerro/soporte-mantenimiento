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
@Table(name = "tipos_mantenimiento", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposMantenimiento.findAll", query = "SELECT t FROM TiposMantenimiento t")
    , @NamedQuery(name = "TiposMantenimiento.findByIdTipoMantenimiento", query = "SELECT t FROM TiposMantenimiento t WHERE t.idTipoMantenimiento = :idTipoMantenimiento")
    , @NamedQuery(name = "TiposMantenimiento.findByNombre", query = "SELECT t FROM TiposMantenimiento t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposMantenimiento.findByDescripcion", query = "SELECT t FROM TiposMantenimiento t WHERE t.descripcion = :descripcion")})
public class TiposMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_mantenimiento", nullable = false)
    private Integer idTipoMantenimiento;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @JoinColumn(name = "id_mantenimiento", referencedColumnName = "id_mantenimiento", nullable = false)
    @ManyToOne(optional = false)
    private Mantenimientos idMantenimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMantenimiento")
    private List<DetallesOrdenTrabajo> detallesOrdenTrabajoList;

    public TiposMantenimiento() {
    }

    public TiposMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public TiposMantenimiento(Integer idTipoMantenimiento, String nombre) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.nombre = nombre;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
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

    public Mantenimientos getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Mantenimientos idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    @XmlTransient
    public List<DetallesOrdenTrabajo> getDetallesOrdenTrabajoList() {
        return detallesOrdenTrabajoList;
    }

    public void setDetallesOrdenTrabajoList(List<DetallesOrdenTrabajo> detallesOrdenTrabajoList) {
        this.detallesOrdenTrabajoList = detallesOrdenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMantenimiento != null ? idTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposMantenimiento)) {
            return false;
        }
        TiposMantenimiento other = (TiposMantenimiento) object;
        if ((this.idTipoMantenimiento == null && other.idTipoMantenimiento != null) || (this.idTipoMantenimiento != null && !this.idTipoMantenimiento.equals(other.idTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposMantenimiento[ idTipoMantenimiento=" + idTipoMantenimiento + " ]";
    }
    
}
