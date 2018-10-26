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
@Table(name = "modelos", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelos.findAll", query = "SELECT m FROM Modelos m")
    , @NamedQuery(name = "Modelos.findByIdModelo", query = "SELECT m FROM Modelos m WHERE m.idModelo = :idModelo")
    , @NamedQuery(name = "Modelos.findByNombre", query = "SELECT m FROM Modelos m WHERE m.nombre = :nombre")})
public class Modelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modelo", nullable = false)
    private Integer idModelo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Fuentes> fuentesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Componentes> componentesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Procesadores> procesadoresList;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marcas idMarca;

    public Modelos() {
    }

    public Modelos(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Modelos(Integer idModelo, String nombre) {
        this.idModelo = idModelo;
        this.nombre = nombre;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Fuentes> getFuentesList() {
        return fuentesList;
    }

    public void setFuentesList(List<Fuentes> fuentesList) {
        this.fuentesList = fuentesList;
    }

    @XmlTransient
    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }

    @XmlTransient
    public List<Procesadores> getProcesadoresList() {
        return procesadoresList;
    }

    public void setProcesadoresList(List<Procesadores> procesadoresList) {
        this.procesadoresList = procesadoresList;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelo != null ? idModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelos)) {
            return false;
        }
        Modelos other = (Modelos) object;
        if ((this.idModelo == null && other.idModelo != null) || (this.idModelo != null && !this.idModelo.equals(other.idModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Modelos[ idModelo=" + idModelo + " ]";
    }
    
}
