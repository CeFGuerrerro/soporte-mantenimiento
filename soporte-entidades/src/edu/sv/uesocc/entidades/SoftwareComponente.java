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
@Table(name = "software_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoftwareComponente.findAll", query = "SELECT s FROM SoftwareComponente s")
    , @NamedQuery(name = "SoftwareComponente.findByIdSoftwareComponente", query = "SELECT s FROM SoftwareComponente s WHERE s.idSoftwareComponente = :idSoftwareComponente")
    , @NamedQuery(name = "SoftwareComponente.findByLicencia", query = "SELECT s FROM SoftwareComponente s WHERE s.licencia = :licencia")
    , @NamedQuery(name = "SoftwareComponente.findBySerial", query = "SELECT s FROM SoftwareComponente s WHERE s.serial = :serial")
    , @NamedQuery(name = "SoftwareComponente.findByObservaciones", query = "SELECT s FROM SoftwareComponente s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "SoftwareComponente.findByFechaInstalacion", query = "SELECT s FROM SoftwareComponente s WHERE s.fechaInstalacion = :fechaInstalacion")})
public class SoftwareComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_software_componente", nullable = false)
    private Integer idSoftwareComponente;
    @Column(name = "licencia")
    private Boolean licencia;
    @Column(name = "serial", length = 2147483647)
    private String serial;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @Column(name = "fecha_instalacion")
    @Temporal(TemporalType.DATE)
    private Date fechaInstalacion;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente", nullable = false)
    @ManyToOne(optional = false)
    private Componentes idComponente;
    @JoinColumn(name = "id_software", referencedColumnName = "id_software", nullable = false)
    @ManyToOne(optional = false)
    private Software idSoftware;

    public SoftwareComponente() {
    }

    public SoftwareComponente(Integer idSoftwareComponente) {
        this.idSoftwareComponente = idSoftwareComponente;
    }

    public Integer getIdSoftwareComponente() {
        return idSoftwareComponente;
    }

    public void setIdSoftwareComponente(Integer idSoftwareComponente) {
        this.idSoftwareComponente = idSoftwareComponente;
    }

    public Boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(Boolean licencia) {
        this.licencia = licencia;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public Componentes getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componentes idComponente) {
        this.idComponente = idComponente;
    }

    public Software getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Software idSoftware) {
        this.idSoftware = idSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftwareComponente != null ? idSoftwareComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareComponente)) {
            return false;
        }
        SoftwareComponente other = (SoftwareComponente) object;
        if ((this.idSoftwareComponente == null && other.idSoftwareComponente != null) || (this.idSoftwareComponente != null && !this.idSoftwareComponente.equals(other.idSoftwareComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.SoftwareComponente[ idSoftwareComponente=" + idSoftwareComponente + " ]";
    }
    
}
