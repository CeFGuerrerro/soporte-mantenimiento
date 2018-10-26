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
@Table(name = "hardware_componente", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HardwareComponente.findAll", query = "SELECT h FROM HardwareComponente h")
    , @NamedQuery(name = "HardwareComponente.findByIdHardwareComponente", query = "SELECT h FROM HardwareComponente h WHERE h.idHardwareComponente = :idHardwareComponente")
    , @NamedQuery(name = "HardwareComponente.findByObservaciones", query = "SELECT h FROM HardwareComponente h WHERE h.observaciones = :observaciones")})
public class HardwareComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hardware_componente", nullable = false)
    private Integer idHardwareComponente;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente", nullable = false)
    @ManyToOne(optional = false)
    private Componentes idComponente;
    @JoinColumn(name = "id_disco", referencedColumnName = "id_disco", nullable = false)
    @ManyToOne(optional = false)
    private Discos idDisco;
    @JoinColumn(name = "id_fuente", referencedColumnName = "id_fuente")
    @ManyToOne
    private Fuentes idFuente;
    @JoinColumn(name = "id_memoria", referencedColumnName = "id_memoria", nullable = false)
    @ManyToOne(optional = false)
    private Memorias idMemoria;
    @JoinColumn(name = "id_motherboard", referencedColumnName = "id_motherboard", nullable = false)
    @ManyToOne(optional = false)
    private Motherboards idMotherboard;
    @JoinColumn(name = "id_procesador", referencedColumnName = "id_procesador", nullable = false)
    @ManyToOne(optional = false)
    private Procesadores idProcesador;
    @JoinColumn(name = "id_tarjeta_video", referencedColumnName = "id_tarjeta_video")
    @ManyToOne
    private TarjetasVideo idTarjetaVideo;

    public HardwareComponente() {
    }

    public HardwareComponente(Integer idHardwareComponente) {
        this.idHardwareComponente = idHardwareComponente;
    }

    public Integer getIdHardwareComponente() {
        return idHardwareComponente;
    }

    public void setIdHardwareComponente(Integer idHardwareComponente) {
        this.idHardwareComponente = idHardwareComponente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Componentes getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componentes idComponente) {
        this.idComponente = idComponente;
    }

    public Discos getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Discos idDisco) {
        this.idDisco = idDisco;
    }

    public Fuentes getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Fuentes idFuente) {
        this.idFuente = idFuente;
    }

    public Memorias getIdMemoria() {
        return idMemoria;
    }

    public void setIdMemoria(Memorias idMemoria) {
        this.idMemoria = idMemoria;
    }

    public Motherboards getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(Motherboards idMotherboard) {
        this.idMotherboard = idMotherboard;
    }

    public Procesadores getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Procesadores idProcesador) {
        this.idProcesador = idProcesador;
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
        hash += (idHardwareComponente != null ? idHardwareComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HardwareComponente)) {
            return false;
        }
        HardwareComponente other = (HardwareComponente) object;
        if ((this.idHardwareComponente == null && other.idHardwareComponente != null) || (this.idHardwareComponente != null && !this.idHardwareComponente.equals(other.idHardwareComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.HardwareComponente[ idHardwareComponente=" + idHardwareComponente + " ]";
    }
    
}
