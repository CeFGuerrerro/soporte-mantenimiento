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
@Table(name = "estados_orden", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosOrden.findAll", query = "SELECT e FROM EstadosOrden e")
    , @NamedQuery(name = "EstadosOrden.findByIdEstado", query = "SELECT e FROM EstadosOrden e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadosOrden.findByNombre", query = "SELECT e FROM EstadosOrden e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EstadosOrden.findByDescripcion", query = "SELECT e FROM EstadosOrden e WHERE e.descripcion = :descripcion")})
public class EstadosOrden implements Serializable {

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
    private List<OrdenesTrabajo> ordenesTrabajoList;

    public EstadosOrden() {
    }

    public EstadosOrden(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadosOrden(Integer idEstado, String nombre) {
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
    public List<OrdenesTrabajo> getOrdenesTrabajoList() {
        return ordenesTrabajoList;
    }

    public void setOrdenesTrabajoList(List<OrdenesTrabajo> ordenesTrabajoList) {
        this.ordenesTrabajoList = ordenesTrabajoList;
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
        if (!(object instanceof EstadosOrden)) {
            return false;
        }
        EstadosOrden other = (EstadosOrden) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.EstadosOrden[ idEstado=" + idEstado + " ]";
    }
    
}
