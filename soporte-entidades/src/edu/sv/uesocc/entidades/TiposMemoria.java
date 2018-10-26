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
@Table(name = "tipos_memoria", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposMemoria.findAll", query = "SELECT t FROM TiposMemoria t")
    , @NamedQuery(name = "TiposMemoria.findByIdTipoMemoria", query = "SELECT t FROM TiposMemoria t WHERE t.idTipoMemoria = :idTipoMemoria")
    , @NamedQuery(name = "TiposMemoria.findByTipoMemoria", query = "SELECT t FROM TiposMemoria t WHERE t.tipoMemoria = :tipoMemoria")})
public class TiposMemoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_memoria", nullable = false)
    private Integer idTipoMemoria;
    @Basic(optional = false)
    @Column(name = "tipo_memoria", nullable = false, length = 2147483647)
    private String tipoMemoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<Memorias> memoriasList;

    public TiposMemoria() {
    }

    public TiposMemoria(Integer idTipoMemoria) {
        this.idTipoMemoria = idTipoMemoria;
    }

    public TiposMemoria(Integer idTipoMemoria, String tipoMemoria) {
        this.idTipoMemoria = idTipoMemoria;
        this.tipoMemoria = tipoMemoria;
    }

    public Integer getIdTipoMemoria() {
        return idTipoMemoria;
    }

    public void setIdTipoMemoria(Integer idTipoMemoria) {
        this.idTipoMemoria = idTipoMemoria;
    }

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
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
        hash += (idTipoMemoria != null ? idTipoMemoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposMemoria)) {
            return false;
        }
        TiposMemoria other = (TiposMemoria) object;
        if ((this.idTipoMemoria == null && other.idTipoMemoria != null) || (this.idTipoMemoria != null && !this.idTipoMemoria.equals(other.idTipoMemoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TiposMemoria[ idTipoMemoria=" + idTipoMemoria + " ]";
    }
    
}
