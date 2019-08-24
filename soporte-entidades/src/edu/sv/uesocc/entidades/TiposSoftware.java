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
@Table(name = "tipos_software", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposSoftware.findAll", query = "SELECT t FROM TiposSoftware t")
    , @NamedQuery(name = "TiposSoftware.findByIdTipoSoftware", query = "SELECT t FROM TiposSoftware t WHERE t.idTipoSoftware = :idTipoSoftware")
    , @NamedQuery(name = "TiposSoftware.findByTipoSoftware", query = "SELECT t FROM TiposSoftware t WHERE t.tipoSoftware = :tipoSoftware")})
public class TiposSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_software", nullable = false)
    private Integer idTipoSoftware;
    @Basic(optional = false)
    @Column(name = "tipo_software", nullable = false, length = 2147483647)
    private String tipoSoftware;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSoftware")
    private List<Software> softwareList;

    public TiposSoftware() {
    }

    public TiposSoftware(Integer idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    public TiposSoftware(Integer idTipoSoftware, String tipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
        this.tipoSoftware = tipoSoftware;
    }

    public Integer getIdTipoSoftware() {
        return idTipoSoftware;
    }

    public void setIdTipoSoftware(Integer idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    public String getTipoSoftware() {
        return tipoSoftware;
    }

    public void setTipoSoftware(String tipoSoftware) {
        this.tipoSoftware = tipoSoftware;
    }

    @XmlTransient
    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSoftware != null ? idTipoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposSoftware)) {
            return false;
        }
        TiposSoftware other = (TiposSoftware) object;
        if ((this.idTipoSoftware == null && other.idTipoSoftware != null) || (this.idTipoSoftware != null && !this.idTipoSoftware.equals(other.idTipoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposSoftware[ idTipoSoftware=" + idTipoSoftware + " ]";
    }
    
}
