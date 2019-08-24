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
@Table(name = "salida_video", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaVideo.findAll", query = "SELECT s FROM SalidaVideo s")
    , @NamedQuery(name = "SalidaVideo.findByIdSalidaVideo", query = "SELECT s FROM SalidaVideo s WHERE s.idSalidaVideo = :idSalidaVideo")
    , @NamedQuery(name = "SalidaVideo.findByTipoSalida", query = "SELECT s FROM SalidaVideo s WHERE s.tipoSalida = :tipoSalida")})
public class SalidaVideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida_video", nullable = false)
    private Integer idSalidaVideo;
    @Basic(optional = false)
    @Column(name = "tipo_salida", nullable = false, length = 2147483647)
    private String tipoSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalidaVideo")
    private List<SalidaTarjetaVideo> salidaTarjetaVideoList;

    public SalidaVideo() {
    }

    public SalidaVideo(Integer idSalidaVideo) {
        this.idSalidaVideo = idSalidaVideo;
    }

    public SalidaVideo(Integer idSalidaVideo, String tipoSalida) {
        this.idSalidaVideo = idSalidaVideo;
        this.tipoSalida = tipoSalida;
    }

    public Integer getIdSalidaVideo() {
        return idSalidaVideo;
    }

    public void setIdSalidaVideo(Integer idSalidaVideo) {
        this.idSalidaVideo = idSalidaVideo;
    }

    public String getTipoSalida() {
        return tipoSalida;
    }

    public void setTipoSalida(String tipoSalida) {
        this.tipoSalida = tipoSalida;
    }

    @XmlTransient
    public List<SalidaTarjetaVideo> getSalidaTarjetaVideoList() {
        return salidaTarjetaVideoList;
    }

    public void setSalidaTarjetaVideoList(List<SalidaTarjetaVideo> salidaTarjetaVideoList) {
        this.salidaTarjetaVideoList = salidaTarjetaVideoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaVideo != null ? idSalidaVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaVideo)) {
            return false;
        }
        SalidaVideo other = (SalidaVideo) object;
        if ((this.idSalidaVideo == null && other.idSalidaVideo != null) || (this.idSalidaVideo != null && !this.idSalidaVideo.equals(other.idSalidaVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.SalidaVideo[ idSalidaVideo=" + idSalidaVideo + " ]";
    }
    
}
