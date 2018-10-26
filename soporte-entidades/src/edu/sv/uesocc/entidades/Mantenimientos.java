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
@Table(name = "mantenimientos", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m")
    , @NamedQuery(name = "Mantenimientos.findByIdMantenimiento", query = "SELECT m FROM Mantenimientos m WHERE m.idMantenimiento = :idMantenimiento")
    , @NamedQuery(name = "Mantenimientos.findByNombre", query = "SELECT m FROM Mantenimientos m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Mantenimientos.findByDescripcion", query = "SELECT m FROM Mantenimientos m WHERE m.descripcion = :descripcion")})
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mantenimiento", nullable = false)
    private Integer idMantenimiento;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimiento")
    private List<TiposMantenimiento> tiposMantenimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMantenimiento")
    private List<OrdenesTrabajo> ordenesTrabajoList;

    public Mantenimientos() {
    }

    public Mantenimientos(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Mantenimientos(Integer idMantenimiento, String nombre) {
        this.idMantenimiento = idMantenimiento;
        this.nombre = nombre;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
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
    public List<TiposMantenimiento> getTiposMantenimientoList() {
        return tiposMantenimientoList;
    }

    public void setTiposMantenimientoList(List<TiposMantenimiento> tiposMantenimientoList) {
        this.tiposMantenimientoList = tiposMantenimientoList;
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
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Mantenimientos[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}
