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
@Table(name = "tipos_disco", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDisco.findAll", query = "SELECT t FROM TiposDisco t")
    , @NamedQuery(name = "TiposDisco.findByIdTipoDisco", query = "SELECT t FROM TiposDisco t WHERE t.idTipoDisco = :idTipoDisco")
    , @NamedQuery(name = "TiposDisco.findByTipoDisco", query = "SELECT t FROM TiposDisco t WHERE t.tipoDisco = :tipoDisco")})
public class TiposDisco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_disco", nullable = false)
    private Integer idTipoDisco;
    @Basic(optional = false)
    @Column(name = "tipo_disco", nullable = false, length = 2147483647)
    private String tipoDisco;
    @OneToMany(mappedBy = "idTipoDisco")
    private List<Discos> discosList;

    public TiposDisco() {
    }

    public TiposDisco(Integer idTipoDisco) {
        this.idTipoDisco = idTipoDisco;
    }

    public TiposDisco(Integer idTipoDisco, String tipoDisco) {
        this.idTipoDisco = idTipoDisco;
        this.tipoDisco = tipoDisco;
    }

    public Integer getIdTipoDisco() {
        return idTipoDisco;
    }

    public void setIdTipoDisco(Integer idTipoDisco) {
        this.idTipoDisco = idTipoDisco;
    }

    public String getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(String tipoDisco) {
        this.tipoDisco = tipoDisco;
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
        hash += (idTipoDisco != null ? idTipoDisco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDisco)) {
            return false;
        }
        TiposDisco other = (TiposDisco) object;
        if ((this.idTipoDisco == null && other.idTipoDisco != null) || (this.idTipoDisco != null && !this.idTipoDisco.equals(other.idTipoDisco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposDisco[ idTipoDisco=" + idTipoDisco + " ]";
    }
    
}
