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
@Table(name = "arquitecturas", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquitecturas.findAll", query = "SELECT a FROM Arquitecturas a")
    , @NamedQuery(name = "Arquitecturas.findByIdArquitectura", query = "SELECT a FROM Arquitecturas a WHERE a.idArquitectura = :idArquitectura")
    , @NamedQuery(name = "Arquitecturas.findByArquitectura", query = "SELECT a FROM Arquitecturas a WHERE a.arquitectura = :arquitectura")})
public class Arquitecturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arquitectura", nullable = false)
    private Integer idArquitectura;
    @Basic(optional = false)
    @Column(name = "arquitectura", nullable = false, length = 2147483647)
    private String arquitectura;
    @OneToMany(mappedBy = "idArquitectura")
    private List<Software> softwareList;
    @OneToMany(mappedBy = "idArquitectura")
    private List<Procesadores> procesadoresList;

    public Arquitecturas() {
    }

    public Arquitecturas(Integer idArquitectura) {
        this.idArquitectura = idArquitectura;
    }

    public Arquitecturas(Integer idArquitectura, String arquitectura) {
        this.idArquitectura = idArquitectura;
        this.arquitectura = arquitectura;
    }

    public Integer getIdArquitectura() {
        return idArquitectura;
    }

    public void setIdArquitectura(Integer idArquitectura) {
        this.idArquitectura = idArquitectura;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    @XmlTransient
    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    @XmlTransient
    public List<Procesadores> getProcesadoresList() {
        return procesadoresList;
    }

    public void setProcesadoresList(List<Procesadores> procesadoresList) {
        this.procesadoresList = procesadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArquitectura != null ? idArquitectura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquitecturas)) {
            return false;
        }
        Arquitecturas other = (Arquitecturas) object;
        if ((this.idArquitectura == null && other.idArquitectura != null) || (this.idArquitectura != null && !this.idArquitectura.equals(other.idArquitectura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Arquitecturas[ idArquitectura=" + idArquitectura + " ]";
    }
    
}
