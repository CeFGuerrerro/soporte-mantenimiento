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
@Table(name = "tipos_componente", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposComponente.findAll", query = "SELECT t FROM TiposComponente t")
    , @NamedQuery(name = "TiposComponente.findByIdTipoComponente", query = "SELECT t FROM TiposComponente t WHERE t.idTipoComponente = :idTipoComponente")
    , @NamedQuery(name = "TiposComponente.findByNombre", query = "SELECT t FROM TiposComponente t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposComponente.findByDescripcion", query = "SELECT t FROM TiposComponente t WHERE t.descripcion = :descripcion")})
public class TiposComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_componente", nullable = false)
    private Integer idTipoComponente;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComponente")
    private List<Componentes> componentesList;

    public TiposComponente() {
    }

    public TiposComponente(Integer idTipoComponente) {
        this.idTipoComponente = idTipoComponente;
    }

    public TiposComponente(Integer idTipoComponente, String nombre) {
        this.idTipoComponente = idTipoComponente;
        this.nombre = nombre;
    }

    public Integer getIdTipoComponente() {
        return idTipoComponente;
    }

    public void setIdTipoComponente(Integer idTipoComponente) {
        this.idTipoComponente = idTipoComponente;
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
    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComponente != null ? idTipoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposComponente)) {
            return false;
        }
        TiposComponente other = (TiposComponente) object;
        if ((this.idTipoComponente == null && other.idTipoComponente != null) || (this.idTipoComponente != null && !this.idTipoComponente.equals(other.idTipoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposComponente[ idTipoComponente=" + idTipoComponente + " ]";
    }
    
}
