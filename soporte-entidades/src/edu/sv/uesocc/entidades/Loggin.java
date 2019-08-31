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
@Table(name = "loggin", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loggin.findAll", query = "SELECT l FROM Loggin l")
    , @NamedQuery(name = "Loggin.findByIdLoggin", query = "SELECT l FROM Loggin l WHERE l.idLoggin = :idLoggin")
    , @NamedQuery(name = "Loggin.findByNombreLoggin", query = "SELECT l FROM Loggin l WHERE l.nombreLoggin = :nombreLoggin")
    , @NamedQuery(name = "Loggin.findByPasswoird", query = "SELECT l FROM Loggin l WHERE l.passwoird = :passwoird")})
public class Loggin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_loggin", nullable = false)
    private Integer idLoggin;
    @Column(name = "nombre_loggin", length = 2147483647)
    private String nombreLoggin;
    @Column(name = "passwoird", length = 2147483647)
    private String passwoird;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    @ManyToOne
    private Tecnicos idTecnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoggin")
    private List<Permisos> permisosList;

    public Loggin() {
    }

    public Loggin(Integer idLoggin) {
        this.idLoggin = idLoggin;
    }

    public Integer getIdLoggin() {
        return idLoggin;
    }

    public void setIdLoggin(Integer idLoggin) {
        this.idLoggin = idLoggin;
    }

    public String getNombreLoggin() {
        return nombreLoggin;
    }

    public void setNombreLoggin(String nombreLoggin) {
        this.nombreLoggin = nombreLoggin;
    }

    public String getPasswoird() {
        return passwoird;
    }

    public void setPasswoird(String passwoird) {
        this.passwoird = passwoird;
    }

    public Tecnicos getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnicos idTecnico) {
        this.idTecnico = idTecnico;
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoggin != null ? idLoggin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loggin)) {
            return false;
        }
        Loggin other = (Loggin) object;
        if ((this.idLoggin == null && other.idLoggin != null) || (this.idLoggin != null && !this.idLoggin.equals(other.idLoggin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Loggin[ idLoggin=" + idLoggin + " ]";
    }
    
}
