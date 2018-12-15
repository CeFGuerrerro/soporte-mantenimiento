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
@Table(name = "ups", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ups.findAll", query = "SELECT u FROM Ups u")
    , @NamedQuery(name = "Ups.findByIdUps", query = "SELECT u FROM Ups u WHERE u.idUps = :idUps")
    , @NamedQuery(name = "Ups.findByBateria", query = "SELECT u FROM Ups u WHERE u.bateria = :bateria")
    , @NamedQuery(name = "Ups.findByEstadoBateria", query = "SELECT u FROM Ups u WHERE u.estadoBateria = :estadoBateria")
    , @NamedQuery(name = "Ups.findByRegulador", query = "SELECT u FROM Ups u WHERE u.regulador = :regulador")
    , @NamedQuery(name = "Ups.findByUltimoCambio", query = "SELECT u FROM Ups u WHERE u.ultimoCambio = :ultimoCambio")
    , @NamedQuery(name = "Ups.findByObservaciones", query = "SELECT u FROM Ups u WHERE u.observaciones = :observaciones")})
public class Ups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ups", nullable = false)
    private Integer idUps;
    @Column(name = "bateria")
    private Boolean bateria;
    @Column(name = "estado_bateria")
    private Boolean estadoBateria;
    @Column(name = "regulador")
    private Boolean regulador;
    @Column(name = "ultimo_cambio")
    @Temporal(TemporalType.DATE)
    private Date ultimoCambio;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente", nullable = false)
    @ManyToOne(optional = false)
    private Componentes idComponente;
    @JoinColumn(name = "id_potencia", referencedColumnName = "id_potencia")
    @ManyToOne
    private PotenciaUps idPotencia;

    public Ups() {
    }

    public Ups(Integer idUps) {
        this.idUps = idUps;
    }

    public Integer getIdUps() {
        return idUps;
    }

    public void setIdUps(Integer idUps) {
        this.idUps = idUps;
    }

    public Boolean getBateria() {
        return bateria;
    }

    public void setBateria(Boolean bateria) {
        this.bateria = bateria;
    }

    public Boolean getEstadoBateria() {
        return estadoBateria;
    }

    public void setEstadoBateria(Boolean estadoBateria) {
        this.estadoBateria = estadoBateria;
    }

    public Boolean getRegulador() {
        return regulador;
    }

    public void setRegulador(Boolean regulador) {
        this.regulador = regulador;
    }

    public Date getUltimoCambio() {
        return ultimoCambio;
    }

    public void setUltimoCambio(Date ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
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

    public PotenciaUps getIdPotencia() {
        return idPotencia;
    }

    public void setIdPotencia(PotenciaUps idPotencia) {
        this.idPotencia = idPotencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUps != null ? idUps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ups)) {
            return false;
        }
        Ups other = (Ups) object;
        if ((this.idUps == null && other.idUps != null) || (this.idUps != null && !this.idUps.equals(other.idUps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Ups[ idUps=" + idUps + " ]";
    }
    
}
