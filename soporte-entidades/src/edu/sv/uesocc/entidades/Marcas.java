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
@Table(name = "marcas", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcas.findAll", query = "SELECT m FROM Marcas m")
    , @NamedQuery(name = "Marcas.findByIdMarca", query = "SELECT m FROM Marcas m WHERE m.idMarca = :idMarca")
    , @NamedQuery(name = "Marcas.findByNombre", query = "SELECT m FROM Marcas m WHERE m.nombre = :nombre")})
public class Marcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca", nullable = false)
    private Integer idMarca;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<Motherboards> motherboardsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<Discos> discosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<Memorias> memoriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<Modelos> modelosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<TarjetasVideo> tarjetasVideoList;

    public Marcas() {
    }

    public Marcas(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Marcas(Integer idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Motherboards> getMotherboardsList() {
        return motherboardsList;
    }

    public void setMotherboardsList(List<Motherboards> motherboardsList) {
        this.motherboardsList = motherboardsList;
    }

    @XmlTransient
    public List<Discos> getDiscosList() {
        return discosList;
    }

    public void setDiscosList(List<Discos> discosList) {
        this.discosList = discosList;
    }

    @XmlTransient
    public List<Memorias> getMemoriasList() {
        return memoriasList;
    }

    public void setMemoriasList(List<Memorias> memoriasList) {
        this.memoriasList = memoriasList;
    }

    @XmlTransient
    public List<Modelos> getModelosList() {
        return modelosList;
    }

    public void setModelosList(List<Modelos> modelosList) {
        this.modelosList = modelosList;
    }

    @XmlTransient
    public List<TarjetasVideo> getTarjetasVideoList() {
        return tarjetasVideoList;
    }

    public void setTarjetasVideoList(List<TarjetasVideo> tarjetasVideoList) {
        this.tarjetasVideoList = tarjetasVideoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcas)) {
            return false;
        }
        Marcas other = (Marcas) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Marcas[ idMarca=" + idMarca + " ]";
    }
    
}
