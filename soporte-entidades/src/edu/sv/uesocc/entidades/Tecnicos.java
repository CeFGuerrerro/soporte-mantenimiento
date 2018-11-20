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
 * @author Cybertron
 */
@Entity
@Table(name = "tecnicos", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicos.findAll", query = "SELECT t FROM Tecnicos t")
    , @NamedQuery(name = "Tecnicos.findByIdTecnico", query = "SELECT t FROM Tecnicos t WHERE t.idTecnico = :idTecnico")
    , @NamedQuery(name = "Tecnicos.findByNombre", query = "SELECT t FROM Tecnicos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tecnicos.findByDescripcion", query = "SELECT t FROM Tecnicos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tecnicos.findByCorreo", query = "SELECT t FROM Tecnicos t WHERE t.correo = :correo")
    , @NamedQuery(name = "Tecnicos.findByEstado", query = "SELECT t FROM Tecnicos t WHERE t.estado = :estado")})
public class Tecnicos implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnico")
    private List<OrdenesTrabajo> ordenesTrabajoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tecnico", nullable = false)
    private Integer idTecnico;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Column(name = "correo", length = 2147483647)
    private String correo;
    @Column(name = "estado")
    private Boolean estado = true;

    public Tecnicos() {
    }

    public Tecnicos(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Tecnicos(Integer idTecnico, String nombre) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTecnico != null ? idTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicos)) {
            return false;
        }
        Tecnicos other = (Tecnicos) object;
        if ((this.idTecnico == null && other.idTecnico != null) || (this.idTecnico != null && !this.idTecnico.equals(other.idTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Tecnicos[ idTecnico=" + idTecnico + " ]";
    }

    @XmlTransient
    public List<OrdenesTrabajo> getOrdenesTrabajoList() {
        return ordenesTrabajoList;
    }

    public void setOrdenesTrabajoList(List<OrdenesTrabajo> ordenesTrabajoList) {
        this.ordenesTrabajoList = ordenesTrabajoList;
    }
    
}
