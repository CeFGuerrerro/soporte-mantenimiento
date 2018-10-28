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
@Table(name = "resposables", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposables.findAll", query = "SELECT r FROM Resposables r")
    , @NamedQuery(name = "Resposables.findByIdResponsable", query = "SELECT r FROM Resposables r WHERE r.idResponsable = :idResponsable")
    , @NamedQuery(name = "Resposables.findByNombre", query = "SELECT r FROM Resposables r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Resposables.findByCorreo", query = "SELECT r FROM Resposables r WHERE r.correo = :correo")})
public class Resposables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_responsable", nullable = false)
    private Integer idResponsable;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "correo", length = 2147483647)
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsable")
    private List<EquiposAsignados> equiposAsignadosList;

    public Resposables() {
    }

    public Resposables(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Resposables(Integer idResponsable, String nombre) {
        this.idResponsable = idResponsable;
        this.nombre = nombre;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<EquiposAsignados> getEquiposAsignadosList() {
        return equiposAsignadosList;
    }

    public void setEquiposAsignadosList(List<EquiposAsignados> equiposAsignadosList) {
        this.equiposAsignadosList = equiposAsignadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResponsable != null ? idResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposables)) {
            return false;
        }
        Resposables other = (Resposables) object;
        if ((this.idResponsable == null && other.idResponsable != null) || (this.idResponsable != null && !this.idResponsable.equals(other.idResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Resposables[ idResponsable=" + idResponsable + " ]";
    }
    
}
