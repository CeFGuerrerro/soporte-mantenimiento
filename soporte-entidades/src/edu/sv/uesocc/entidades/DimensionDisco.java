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
@Table(name = "dimension_disco", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimensionDisco.findAll", query = "SELECT d FROM DimensionDisco d")
    , @NamedQuery(name = "DimensionDisco.findByIdDimension", query = "SELECT d FROM DimensionDisco d WHERE d.idDimension = :idDimension")
    , @NamedQuery(name = "DimensionDisco.findByDimension", query = "SELECT d FROM DimensionDisco d WHERE d.dimension = :dimension")})
public class DimensionDisco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dimension", nullable = false)
    private Integer idDimension;
    @Basic(optional = false)
    @Column(name = "dimension", nullable = false, length = 2147483647)
    private String dimension;
    @OneToMany(mappedBy = "idDimension")
    private List<Discos> discosList;

    public DimensionDisco() {
    }

    public DimensionDisco(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public DimensionDisco(Integer idDimension, String dimension) {
        this.idDimension = idDimension;
        this.dimension = dimension;
    }

    public Integer getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @XmlTransient
    public List<Discos> getDiscosList() {
        return discosList;
    }

    public void setDiscosList(List<Discos> discosList) {
        this.discosList = discosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDimension != null ? idDimension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimensionDisco)) {
            return false;
        }
        DimensionDisco other = (DimensionDisco) object;
        if ((this.idDimension == null && other.idDimension != null) || (this.idDimension != null && !this.idDimension.equals(other.idDimension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.DimensionDisco[ idDimension=" + idDimension + " ]";
    }
    
}
