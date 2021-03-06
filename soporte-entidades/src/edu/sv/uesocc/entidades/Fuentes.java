/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "fuentes", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuentes.findAll", query = "SELECT f FROM Fuentes f")
    , @NamedQuery(name = "Fuentes.findByIdFuente", query = "SELECT f FROM Fuentes f WHERE f.idFuente = :idFuente")
    , @NamedQuery(name = "Fuentes.findByPotencia", query = "SELECT f FROM Fuentes f WHERE f.potencia = :potencia")
    , @NamedQuery(name = "Fuentes.findByNumeroPines", query = "SELECT f FROM Fuentes f WHERE f.numeroPines = :numeroPines")
    , @NamedQuery(name = "Fuentes.findByNumeroSerie", query = "SELECT f FROM Fuentes f WHERE f.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "Fuentes.findByEstado", query = "SELECT f FROM Fuentes f WHERE f.estado = :estado")
    , @NamedQuery(name = "Fuentes.findByAsignado", query = "SELECT f FROM Fuentes f WHERE f.asignado = :asignado")
    , @NamedQuery(name = "Fuentes.findByFechaDeBaja", query = "SELECT f FROM Fuentes f WHERE f.fechaDeBaja = :fechaDeBaja")
    , @NamedQuery(name = "Fuentes.findByObservaciones", query = "SELECT f FROM Fuentes f WHERE f.observaciones = :observaciones")})
public class Fuentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fuente", nullable = false)
    private Integer idFuente;
    @Column(name = "potencia", length = 2147483647)
    private String potencia;
    @Column(name = "numero_pines", length = 2147483647)
    private String numeroPines;
    @Column(name = "numero_serie", length = 2147483647)
    private String numeroSerie;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "asignado")
    private Boolean asignado;
    @Column(name = "fecha_de_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaDeBaja;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(mappedBy = "idFuente")
    private List<FuenteComponente> fuenteComponenteList;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelos idModelo;

    public Fuentes() {
    }

    public Fuentes(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getNumeroPines() {
        return numeroPines;
    }

    public void setNumeroPines(String numeroPines) {
        this.numeroPines = numeroPines;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public Date getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(Date fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<FuenteComponente> getFuenteComponenteList() {
        return fuenteComponenteList;
    }

    public void setFuenteComponenteList(List<FuenteComponente> fuenteComponenteList) {
        this.fuenteComponenteList = fuenteComponenteList;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuente != null ? idFuente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuentes)) {
            return false;
        }
        Fuentes other = (Fuentes) object;
        if ((this.idFuente == null && other.idFuente != null) || (this.idFuente != null && !this.idFuente.equals(other.idFuente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Fuentes[ idFuente=" + idFuente + " ]";
    }
    
}
