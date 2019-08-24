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
@Table(name = "motherboard_componente", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotherboardComponente.findAll", query = "SELECT m FROM MotherboardComponente m")
    , @NamedQuery(name = "MotherboardComponente.findByIdMotherboardComponente", query = "SELECT m FROM MotherboardComponente m WHERE m.idMotherboardComponente = :idMotherboardComponente")
    , @NamedQuery(name = "MotherboardComponente.findByFechaAsignado", query = "SELECT m FROM MotherboardComponente m WHERE m.fechaAsignado = :fechaAsignado")
    , @NamedQuery(name = "MotherboardComponente.findByFechaCambio", query = "SELECT m FROM MotherboardComponente m WHERE m.fechaCambio = :fechaCambio")
    , @NamedQuery(name = "MotherboardComponente.findByEstado", query = "SELECT m FROM MotherboardComponente m WHERE m.estado = :estado")
    , @NamedQuery(name = "MotherboardComponente.findByObservaciones", query = "SELECT m FROM MotherboardComponente m WHERE m.observaciones = :observaciones")})
public class MotherboardComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motherboard_componente", nullable = false)
    private Integer idMotherboardComponente;
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
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componentes idComponente;
    @JoinColumn(name = "id_motherboard", referencedColumnName = "id_motherboard")
    @ManyToOne
    private Motherboards idMotherboard;

    public MotherboardComponente() {
    }

    public MotherboardComponente(Integer idMotherboardComponente) {
        this.idMotherboardComponente = idMotherboardComponente;
    }

    public Integer getIdMotherboardComponente() {
        return idMotherboardComponente;
    }

    public void setIdMotherboardComponente(Integer idMotherboardComponente) {
        this.idMotherboardComponente = idMotherboardComponente;
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

    public Componentes getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componentes idComponente) {
        this.idComponente = idComponente;
    }

    public Motherboards getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(Motherboards idMotherboard) {
        this.idMotherboard = idMotherboard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotherboardComponente != null ? idMotherboardComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotherboardComponente)) {
            return false;
        }
        MotherboardComponente other = (MotherboardComponente) object;
        if ((this.idMotherboardComponente == null && other.idMotherboardComponente != null) || (this.idMotherboardComponente != null && !this.idMotherboardComponente.equals(other.idMotherboardComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.MotherboardComponente[ idMotherboardComponente=" + idMotherboardComponente + " ]";
    }
    
}
