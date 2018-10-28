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
@Table(name = "capacidades", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacidades.findAll", query = "SELECT c FROM Capacidades c")
    , @NamedQuery(name = "Capacidades.findByIdCapacidad", query = "SELECT c FROM Capacidades c WHERE c.idCapacidad = :idCapacidad")
    , @NamedQuery(name = "Capacidades.findByCapacidad", query = "SELECT c FROM Capacidades c WHERE c.capacidad = :capacidad")})
public class Capacidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_capacidad", nullable = false)
    private Integer idCapacidad;
    @Basic(optional = false)
    @Column(name = "capacidad", nullable = false, length = 2147483647)
    private String capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCapacidad")
    private List<Discos> discosList;
    @OneToMany(mappedBy = "idCapacidad")
    private List<Memorias> memoriasList;

    public Capacidades() {
    }

    public Capacidades(Integer idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public Capacidades(Integer idCapacidad, String capacidad) {
        this.idCapacidad = idCapacidad;
        this.capacidad = capacidad;
    }

    public Integer getIdCapacidad() {
        return idCapacidad;
    }

    public void setIdCapacidad(Integer idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public List<Discos> getDiscosList() {
        return discosList;
    }

    public void setDiscosList(List<Discos> discosList) {
        this.discosList = discosList;
    }

    @XmlTransient
    public List<Memorias> getMemoriasList() {
        return memoriasList;
    }

    public void setMemoriasList(List<Memorias> memoriasList) {
        this.memoriasList = memoriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacidad != null ? idCapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacidades)) {
            return false;
        }
        Capacidades other = (Capacidades) object;
        if ((this.idCapacidad == null && other.idCapacidad != null) || (this.idCapacidad != null && !this.idCapacidad.equals(other.idCapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Capacidades[ idCapacidad=" + idCapacidad + " ]";
    }
    
}
