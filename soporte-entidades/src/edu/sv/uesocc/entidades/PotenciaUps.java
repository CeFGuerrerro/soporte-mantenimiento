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
@Table(name = "potencia_ups", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PotenciaUps.findAll", query = "SELECT p FROM PotenciaUps p")
    , @NamedQuery(name = "PotenciaUps.findByIdPotencia", query = "SELECT p FROM PotenciaUps p WHERE p.idPotencia = :idPotencia")
    , @NamedQuery(name = "PotenciaUps.findByVoltaje", query = "SELECT p FROM PotenciaUps p WHERE p.voltaje = :voltaje")
    , @NamedQuery(name = "PotenciaUps.findByAmperaje", query = "SELECT p FROM PotenciaUps p WHERE p.amperaje = :amperaje")})
public class PotenciaUps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_potencia", nullable = false)
    private Integer idPotencia;
    @Column(name = "voltaje", length = 2147483647)
    private String voltaje;
    @Column(name = "amperaje", length = 2147483647)
    private String amperaje;
    @OneToMany(mappedBy = "idPotencia")
    private List<Ups> upsList;

    public PotenciaUps() {
    }

    public PotenciaUps(Integer idPotencia) {
        this.idPotencia = idPotencia;
    }

    public Integer getIdPotencia() {
        return idPotencia;
    }

    public void setIdPotencia(Integer idPotencia) {
        this.idPotencia = idPotencia;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getAmperaje() {
        return amperaje;
    }

    public void setAmperaje(String amperaje) {
        this.amperaje = amperaje;
    }

    @XmlTransient
    public List<Ups> getUpsList() {
        return upsList;
    }

    public void setUpsList(List<Ups> upsList) {
        this.upsList = upsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPotencia != null ? idPotencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PotenciaUps)) {
            return false;
        }
        PotenciaUps other = (PotenciaUps) object;
        if ((this.idPotencia == null && other.idPotencia != null) || (this.idPotencia != null && !this.idPotencia.equals(other.idPotencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.PotenciaUps[ idPotencia=" + idPotencia + " ]";
    }
    
}
