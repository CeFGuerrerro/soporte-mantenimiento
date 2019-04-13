/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author o-a19
 */
@Entity
@Table(name = "vistas_loggin", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistasLoggin.findAll", query = "SELECT v FROM VistasLoggin v")
    , @NamedQuery(name = "VistasLoggin.findByIdVistasLoggin", query = "SELECT v FROM VistasLoggin v WHERE v.idVistasLoggin = :idVistasLoggin")})
public class VistasLoggin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vistas_loggin", nullable = false)
    private Integer idVistasLoggin;
    @JoinColumn(name = "id_loggin", referencedColumnName = "id_loggin")
    @ManyToOne
    private Loggin idLoggin;
    @JoinColumn(name = "id_vista", referencedColumnName = "id_vista")
    @ManyToOne
    private Vistas idVista;

    public VistasLoggin() {
    }

    public VistasLoggin(Integer idVistasLoggin) {
        this.idVistasLoggin = idVistasLoggin;
    }

    public Integer getIdVistasLoggin() {
        return idVistasLoggin;
    }

    public void setIdVistasLoggin(Integer idVistasLoggin) {
        this.idVistasLoggin = idVistasLoggin;
    }

    public Loggin getIdLoggin() {
        return idLoggin;
    }

    public void setIdLoggin(Loggin idLoggin) {
        this.idLoggin = idLoggin;
    }

    public Vistas getIdVista() {
        return idVista;
    }

    public void setIdVista(Vistas idVista) {
        this.idVista = idVista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVistasLoggin != null ? idVistasLoggin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistasLoggin)) {
            return false;
        }
        VistasLoggin other = (VistasLoggin) object;
        if ((this.idVistasLoggin == null && other.idVistasLoggin != null) || (this.idVistasLoggin != null && !this.idVistasLoggin.equals(other.idVistasLoggin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.VistasLoggin[ idVistasLoggin=" + idVistasLoggin + " ]";
    }
    
}
