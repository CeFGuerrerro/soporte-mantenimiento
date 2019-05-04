/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "tarjetas_video_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetasVideoComponente.findAll", query = "SELECT t FROM TarjetasVideoComponente t")
    , @NamedQuery(name = "TarjetasVideoComponente.findByIdTarjetaVideoComponente", query = "SELECT t FROM TarjetasVideoComponente t WHERE t.idTarjetaVideoComponente = :idTarjetaVideoComponente")
    , @NamedQuery(name = "TarjetasVideoComponente.findByFechaAsignado", query = "SELECT t FROM TarjetasVideoComponente t WHERE t.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "TarjetasVideoComponente.findByFechaCambio", query = "SELECT t FROM TarjetasVideoComponente t WHERE t.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "TarjetasVideoComponente.findByEstado", query = "SELECT t FROM TarjetasVideoComponente t WHERE t.estado = :estado")
    , @NamedQuery(name = "TarjetasVideoComponente.findByObservaciones", query = "SELECT t FROM TarjetasVideoComponente t WHERE t.observaciones = :observaciones")})
public class TarjetasVideoComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta_video_componente", nullable = false)
    private Integer idTarjetaVideoComponente;
    @Column(name = "fecha_asignado")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignado;
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_tarjeta_video", referencedColumnName = "id_tarjeta_video")
    @ManyToOne
    private TarjetasVideo idTarjetaVideo;

    public TarjetasVideoComponente() {
    }

    public TarjetasVideoComponente(Integer idTarjetaVideoComponente) {
        this.idTarjetaVideoComponente = idTarjetaVideoComponente;
    }

    public Integer getIdTarjetaVideoComponente() {
        return idTarjetaVideoComponente;
    }

    public void setIdTarjetaVideoComponente(Integer idTarjetaVideoComponente) {
        this.idTarjetaVideoComponente = idTarjetaVideoComponente;
    }

    public Date getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(Date fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        hash += (idTarjetaVideoComponente != null ? idTarjetaVideoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetasVideoComponente)) {
            return false;
        }
        TarjetasVideoComponente other = (TarjetasVideoComponente) object;
        if ((this.idTarjetaVideoComponente == null && other.idTarjetaVideoComponente != null) || (this.idTarjetaVideoComponente != null && !this.idTarjetaVideoComponente.equals(other.idTarjetaVideoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.TarjetasVideoComponente[ idTarjetaVideoComponente=" + idTarjetaVideoComponente + " ]";
    }
    
}
