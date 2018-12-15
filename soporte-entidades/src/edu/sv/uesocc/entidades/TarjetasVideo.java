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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tarjetas_video", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetasVideo.findAll", query = "SELECT t FROM TarjetasVideo t")
    , @NamedQuery(name = "TarjetasVideo.findByIdTarjetaVideo", query = "SELECT t FROM TarjetasVideo t WHERE t.idTarjetaVideo = :idTarjetaVideo")
    , @NamedQuery(name = "TarjetasVideo.findByNumeroSerial", query = "SELECT t FROM TarjetasVideo t WHERE t.numeroSerial = :numeroSerial")})
public class TarjetasVideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta_video", nullable = false)
    private Integer idTarjetaVideo;
    @Column(name = "numero_serial", length = 2147483647)
    private String numeroSerial;
    @OneToMany(mappedBy = "idTarjetaVideo")
    private List<SalidaTarjetaVideo> salidaTarjetaVideoList;
    @OneToMany(mappedBy = "idTarjetaVideo")
    private List<HardwareComponente> hardwareComponenteList;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @JoinColumn(name = "id_puerto", referencedColumnName = "id_puerto", nullable = false)
    @ManyToOne(optional = false)
    private Puertos idPuerto;

    public TarjetasVideo() {
    }

    public TarjetasVideo(Integer idTarjetaVideo) {
        this.idTarjetaVideo = idTarjetaVideo;
    }

    public Integer getIdTarjetaVideo() {
        return idTarjetaVideo;
    }

    public void setIdTarjetaVideo(Integer idTarjetaVideo) {
        this.idTarjetaVideo = idTarjetaVideo;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    @XmlTransient
    public List<SalidaTarjetaVideo> getSalidaTarjetaVideoList() {
        return salidaTarjetaVideoList;
    }

    public void setSalidaTarjetaVideoList(List<SalidaTarjetaVideo> salidaTarjetaVideoList) {
        this.salidaTarjetaVideoList = salidaTarjetaVideoList;
    }

    @XmlTransient
    public List<HardwareComponente> getHardwareComponenteList() {
        return hardwareComponenteList;
    }

    public void setHardwareComponenteList(List<HardwareComponente> hardwareComponenteList) {
        this.hardwareComponenteList = hardwareComponenteList;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Puertos getIdPuerto() {
        return idPuerto;
    }

    public void setIdPuerto(Puertos idPuerto) {
        this.idPuerto = idPuerto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjetaVideo != null ? idTarjetaVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetasVideo)) {
            return false;
        }
        TarjetasVideo other = (TarjetasVideo) object;
        if ((this.idTarjetaVideo == null && other.idTarjetaVideo != null) || (this.idTarjetaVideo != null && !this.idTarjetaVideo.equals(other.idTarjetaVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TarjetasVideo[ idTarjetaVideo=" + idTarjetaVideo + " ]";
    }
    
}
