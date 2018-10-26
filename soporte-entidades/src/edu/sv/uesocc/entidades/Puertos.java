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
@Table(name = "puertos", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puertos.findAll", query = "SELECT p FROM Puertos p")
    , @NamedQuery(name = "Puertos.findByIdPuerto", query = "SELECT p FROM Puertos p WHERE p.idPuerto = :idPuerto")
    , @NamedQuery(name = "Puertos.findByTipoPuerto", query = "SELECT p FROM Puertos p WHERE p.tipoPuerto = :tipoPuerto")})
public class Puertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puerto", nullable = false)
    private Integer idPuerto;
    @Basic(optional = false)
    @Column(name = "tipo_puerto", nullable = false, length = 2147483647)
    private String tipoPuerto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuerto")
    private List<Discos> discosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuerto")
    private List<TarjetasVideo> tarjetasVideoList;

    public Puertos() {
    }

    public Puertos(Integer idPuerto) {
        this.idPuerto = idPuerto;
    }

    public Puertos(Integer idPuerto, String tipoPuerto) {
        this.idPuerto = idPuerto;
        this.tipoPuerto = tipoPuerto;
    }

    public Integer getIdPuerto() {
        return idPuerto;
    }

    public void setIdPuerto(Integer idPuerto) {
        this.idPuerto = idPuerto;
    }

    public String getTipoPuerto() {
        return tipoPuerto;
    }

    public void setTipoPuerto(String tipoPuerto) {
        this.tipoPuerto = tipoPuerto;
    }

    @XmlTransient
    public List<Discos> getDiscosList() {
        return discosList;
    }

    public void setDiscosList(List<Discos> discosList) {
        this.discosList = discosList;
    }

    @XmlTransient
    public List<TarjetasVideo> getTarjetasVideoList() {
        return tarjetasVideoList;
    }

    public void setTarjetasVideoList(List<TarjetasVideo> tarjetasVideoList) {
        this.tarjetasVideoList = tarjetasVideoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuerto != null ? idPuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puertos)) {
            return false;
        }
        Puertos other = (Puertos) object;
        if ((this.idPuerto == null && other.idPuerto != null) || (this.idPuerto != null && !this.idPuerto.equals(other.idPuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Puertos[ idPuerto=" + idPuerto + " ]";
    }
    
}
