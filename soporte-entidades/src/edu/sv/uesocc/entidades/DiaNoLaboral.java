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
@Table(name = "dia_no_laboral", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaNoLaboral.findAll", query = "SELECT d FROM DiaNoLaboral d")
    , @NamedQuery(name = "DiaNoLaboral.findByIdDia", query = "SELECT d FROM DiaNoLaboral d WHERE d.idDia = :idDia")
    , @NamedQuery(name = "DiaNoLaboral.findByFecha", query = "SELECT d FROM DiaNoLaboral d WHERE d.fecha = :fecha")})
public class DiaNoLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dia", nullable = false)
    private Integer idDia;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public DiaNoLaboral() {
    }

    public DiaNoLaboral(Integer idDia) {
        this.idDia = idDia;
    }

    public DiaNoLaboral(Integer idDia, Date fecha) {
        this.idDia = idDia;
        this.fecha = fecha;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDia != null ? idDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaNoLaboral)) {
            return false;
        }
        DiaNoLaboral other = (DiaNoLaboral) object;
        if ((this.idDia == null && other.idDia != null) || (this.idDia != null && !this.idDia.equals(other.idDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.DiaNoLaboral[ idDia=" + idDia + " ]";
    }
    
}
