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
@Table(name = "motherboards", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motherboards.findAll", query = "SELECT m FROM Motherboards m")
    , @NamedQuery(name = "Motherboards.findByIdMotherboard", query = "SELECT m FROM Motherboards m WHERE m.idMotherboard = :idMotherboard")
    , @NamedQuery(name = "Motherboards.findByNumeroSerie", query = "SELECT m FROM Motherboards m WHERE m.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "Motherboards.findByEstado", query = "SELECT m FROM Motherboards m WHERE m.estado = :estado")
    , @NamedQuery(name = "Motherboards.findByAsignado", query = "SELECT m FROM Motherboards m WHERE m.asignado = :asignado")
    , @NamedQuery(name = "Motherboards.findByFechaDeBaja", query = "SELECT m FROM Motherboards m WHERE m.fechaDeBaja = :fechaDeBaja")
    , @NamedQuery(name = "Motherboards.findByObservaciones", query = "SELECT m FROM Motherboards m WHERE m.observaciones = :observaciones")})
public class Motherboards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motherboard", nullable = false)
    private Integer idMotherboard;
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
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @JoinColumn(name = "id_socket", referencedColumnName = "id_socket")
    @ManyToOne
    private Sockets idSocket;

    public Motherboards() {
    }

    public Motherboards(Integer idMotherboard) {
        this.idMotherboard = idMotherboard;
    }

    public Integer getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(Integer idMotherboard) {
        this.idMotherboard = idMotherboard;
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

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Sockets getIdSocket() {
        return idSocket;
    }

    public void setIdSocket(Sockets idSocket) {
        this.idSocket = idSocket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotherboard != null ? idMotherboard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motherboards)) {
            return false;
        }
        Motherboards other = (Motherboards) object;
        if ((this.idMotherboard == null && other.idMotherboard != null) || (this.idMotherboard != null && !this.idMotherboard.equals(other.idMotherboard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Motherboards[ idMotherboard=" + idMotherboard + " ]";
    }
    
}
