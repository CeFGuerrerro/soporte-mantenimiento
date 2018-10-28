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
@Table(name = "cronograma", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cronograma.findAll", query = "SELECT c FROM Cronograma c")
    , @NamedQuery(name = "Cronograma.findByIdCronograma", query = "SELECT c FROM Cronograma c WHERE c.idCronograma = :idCronograma")
    , @NamedQuery(name = "Cronograma.findByFecha", query = "SELECT c FROM Cronograma c WHERE c.fecha = :fecha")})
public class Cronograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cronograma", nullable = false)
    private Integer idCronograma;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipos idEquipo;

    public Cronograma() {
    }

    public Cronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Cronograma(Integer idCronograma, Date fecha) {
        this.idCronograma = idCronograma;
        this.fecha = fecha;
    }

    public Integer getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCronograma != null ? idCronograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.idCronograma == null && other.idCronograma != null) || (this.idCronograma != null && !this.idCronograma.equals(other.idCronograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Cronograma[ idCronograma=" + idCronograma + " ]";
    }
    
}
