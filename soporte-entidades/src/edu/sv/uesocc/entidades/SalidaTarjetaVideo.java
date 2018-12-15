/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "salida_tarjeta_video", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaTarjetaVideo.findAll", query = "SELECT s FROM SalidaTarjetaVideo s")
    , @NamedQuery(name = "SalidaTarjetaVideo.findByIdSalidaTarjetaVideo", query = "SELECT s FROM SalidaTarjetaVideo s WHERE s.idSalidaTarjetaVideo = :idSalidaTarjetaVideo")})
public class SalidaTarjetaVideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida_tarjeta_video", nullable = false)
    private Integer idSalidaTarjetaVideo;
    @JoinColumn(name = "id_salida_video", referencedColumnName = "id_salida_video", nullable = false)
    @ManyToOne(optional = false)
    private SalidaVideo idSalidaVideo;
    @JoinColumn(name = "id_tarjeta_video", referencedColumnName = "id_tarjeta_video", nullable = false)
    @ManyToOne(optional = false)
    private TarjetasVideo idTarjetaVideo;

    public SalidaTarjetaVideo() {
    }

    public SalidaTarjetaVideo(Integer idSalidaTarjetaVideo) {
        this.idSalidaTarjetaVideo = idSalidaTarjetaVideo;
    }

    public Integer getIdSalidaTarjetaVideo() {
        return idSalidaTarjetaVideo;
    }

    public void setIdSalidaTarjetaVideo(Integer idSalidaTarjetaVideo) {
        this.idSalidaTarjetaVideo = idSalidaTarjetaVideo;
    }

    public SalidaVideo getIdSalidaVideo() {
        return idSalidaVideo;
    }

    public void setIdSalidaVideo(SalidaVideo idSalidaVideo) {
        this.idSalidaVideo = idSalidaVideo;
    }

    public TarjetasVideo getIdTarjetaVideo() {
        return idTarjetaVideo;
    }

    public void setIdTarjetaVideo(TarjetasVideo idTarjetaVideo) {
        this.idTarjetaVideo = idTarjetaVideo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaTarjetaVideo != null ? idSalidaTarjetaVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaTarjetaVideo)) {
            return false;
        }
        SalidaTarjetaVideo other = (SalidaTarjetaVideo) object;
        if ((this.idSalidaTarjetaVideo == null && other.idSalidaTarjetaVideo != null) || (this.idSalidaTarjetaVideo != null && !this.idSalidaTarjetaVideo.equals(other.idSalidaTarjetaVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.SalidaTarjetaVideo[ idSalidaTarjetaVideo=" + idSalidaTarjetaVideo + " ]";
    }
    
}
