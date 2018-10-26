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
@Table(name = "memorias", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memorias.findAll", query = "SELECT m FROM Memorias m")
    , @NamedQuery(name = "Memorias.findByIdMemoria", query = "SELECT m FROM Memorias m WHERE m.idMemoria = :idMemoria")
    , @NamedQuery(name = "Memorias.findByNumeroSerie", query = "SELECT m FROM Memorias m WHERE m.numeroSerie = :numeroSerie")})
public class Memorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_memoria", nullable = false)
    private Integer idMemoria;
    @Column(name = "numero_serie", length = 2147483647)
    private String numeroSerie;
    @JoinColumn(name = "id_capacidad", referencedColumnName = "id_capacidad")
    @ManyToOne
    private Capacidades idCapacidad;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_memoria", nullable = false)
    @ManyToOne(optional = false)
    private TiposMemoria idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMemoria")
    private List<HardwareComponente> hardwareComponenteList;

    public Memorias() {
    }

    public Memorias(Integer idMemoria) {
        this.idMemoria = idMemoria;
    }

    public Integer getIdMemoria() {
        return idMemoria;
    }

    public void setIdMemoria(Integer idMemoria) {
        this.idMemoria = idMemoria;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Capacidades getIdCapacidad() {
        return idCapacidad;
    }

    public void setIdCapacidad(Capacidades idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public TiposMemoria getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TiposMemoria idTipo) {
        this.idTipo = idTipo;
    }

    @XmlTransient
    public List<HardwareComponente> getHardwareComponenteList() {
        return hardwareComponenteList;
    }

    public void setHardwareComponenteList(List<HardwareComponente> hardwareComponenteList) {
        this.hardwareComponenteList = hardwareComponenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMemoria != null ? idMemoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memorias)) {
            return false;
        }
        Memorias other = (Memorias) object;
        if ((this.idMemoria == null && other.idMemoria != null) || (this.idMemoria != null && !this.idMemoria.equals(other.idMemoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Memorias[ idMemoria=" + idMemoria + " ]";
    }
    
}
