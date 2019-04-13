/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "vistas", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistas.findAll", query = "SELECT v FROM Vistas v")
    , @NamedQuery(name = "Vistas.findByIdVista", query = "SELECT v FROM Vistas v WHERE v.idVista = :idVista")
    , @NamedQuery(name = "Vistas.findByNombre", query = "SELECT v FROM Vistas v WHERE v.nombre = :nombre")})
public class Vistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vista", nullable = false)
    private Integer idVista;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @OneToMany(mappedBy = "idVista")
    private List<VistasLoggin> vistasLogginList;

    public Vistas() {
    }

    public Vistas(Integer idVista) {
        this.idVista = idVista;
    }

    public Vistas(Integer idVista, String nombre) {
        this.idVista = idVista;
        this.nombre = nombre;
    }

    public Integer getIdVista() {
        return idVista;
    }

    public void setIdVista(Integer idVista) {
        this.idVista = idVista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<VistasLoggin> getVistasLogginList() {
        return vistasLogginList;
    }

    public void setVistasLogginList(List<VistasLoggin> vistasLogginList) {
        this.vistasLogginList = vistasLogginList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVista != null ? idVista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vistas)) {
            return false;
        }
        Vistas other = (Vistas) object;
        if ((this.idVista == null && other.idVista != null) || (this.idVista != null && !this.idVista.equals(other.idVista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Vistas[ idVista=" + idVista + " ]";
    }
    
}
