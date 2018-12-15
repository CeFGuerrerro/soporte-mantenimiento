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
@Table(name = "software", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s")
    , @NamedQuery(name = "Software.findByIdSoftware", query = "SELECT s FROM Software s WHERE s.idSoftware = :idSoftware")
    , @NamedQuery(name = "Software.findByNombre", query = "SELECT s FROM Software s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Software.findByVersion", query = "SELECT s FROM Software s WHERE s.version = :version")
    , @NamedQuery(name = "Software.findByServicePack", query = "SELECT s FROM Software s WHERE s.servicePack = :servicePack")
    , @NamedQuery(name = "Software.findByDescripcion", query = "SELECT s FROM Software s WHERE s.descripcion = :descripcion")})
public class Software implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_software", nullable = false)
    private Integer idSoftware;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "version", length = 2147483647)
    private String version;
    @Column(name = "service_pack", length = 2147483647)
    private String servicePack;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @JoinColumn(name = "id_arquitectura", referencedColumnName = "id_arquitectura", nullable = false)
    @ManyToOne(optional = false)
    private Arquitecturas idArquitectura;
    @JoinColumn(name = "id_tipo_software", referencedColumnName = "id_tipo_software", nullable = false)
    @ManyToOne(optional = false)
    private TiposSoftware idTipoSoftware;
    @OneToMany(mappedBy = "idSoftware")
    private List<SoftwareComponente> softwareComponenteList;

    public Software() {
    }

    public Software(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public Software(Integer idSoftware, String nombre) {
        this.idSoftware = idSoftware;
        this.nombre = nombre;
    }

    public Integer getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServicePack() {
        return servicePack;
    }

    public void setServicePack(String servicePack) {
        this.servicePack = servicePack;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Arquitecturas getIdArquitectura() {
        return idArquitectura;
    }

    public void setIdArquitectura(Arquitecturas idArquitectura) {
        this.idArquitectura = idArquitectura;
    }

    public TiposSoftware getIdTipoSoftware() {
        return idTipoSoftware;
    }

    public void setIdTipoSoftware(TiposSoftware idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    @XmlTransient
    public List<SoftwareComponente> getSoftwareComponenteList() {
        return softwareComponenteList;
    }

    public void setSoftwareComponenteList(List<SoftwareComponente> softwareComponenteList) {
        this.softwareComponenteList = softwareComponenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftware != null ? idSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Software)) {
            return false;
        }
        Software other = (Software) object;
        if ((this.idSoftware == null && other.idSoftware != null) || (this.idSoftware != null && !this.idSoftware.equals(other.idSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Software[ idSoftware=" + idSoftware + " ]";
    }
    
}
