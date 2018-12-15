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
@Table(name = "velocidad", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Velocidad.findAll", query = "SELECT v FROM Velocidad v")
    , @NamedQuery(name = "Velocidad.findByIdVelocidad", query = "SELECT v FROM Velocidad v WHERE v.idVelocidad = :idVelocidad")
    , @NamedQuery(name = "Velocidad.findByVelocidad", query = "SELECT v FROM Velocidad v WHERE v.velocidad = :velocidad")})
public class Velocidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_velocidad", nullable = false)
    private Integer idVelocidad;
    @Basic(optional = false)
    @Column(name = "velocidad", nullable = false, length = 2147483647)
    private String velocidad;
    @OneToMany(mappedBy = "idVelocidad")
    private List<Memorias> memoriasList;

    public Velocidad() {
    }

    public Velocidad(Integer idVelocidad) {
        this.idVelocidad = idVelocidad;
    }

    public Velocidad(Integer idVelocidad, String velocidad) {
        this.idVelocidad = idVelocidad;
        this.velocidad = velocidad;
    }

    public Integer getIdVelocidad() {
        return idVelocidad;
    }

    public void setIdVelocidad(Integer idVelocidad) {
        this.idVelocidad = idVelocidad;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
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
        hash += (idVelocidad != null ? idVelocidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Velocidad)) {
            return false;
        }
        Velocidad other = (Velocidad) object;
        if ((this.idVelocidad == null && other.idVelocidad != null) || (this.idVelocidad != null && !this.idVelocidad.equals(other.idVelocidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Velocidad[ idVelocidad=" + idVelocidad + " ]";
    }
    
}
