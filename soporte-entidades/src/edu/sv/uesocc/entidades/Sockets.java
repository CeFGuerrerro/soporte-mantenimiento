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
@Table(name = "sockets", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sockets.findAll", query = "SELECT s FROM Sockets s")
    , @NamedQuery(name = "Sockets.findByIdSocket", query = "SELECT s FROM Sockets s WHERE s.idSocket = :idSocket")
    , @NamedQuery(name = "Sockets.findBySocket", query = "SELECT s FROM Sockets s WHERE s.socket = :socket")})
public class Sockets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_socket", nullable = false)
    private Integer idSocket;
    @Basic(optional = false)
    @Column(name = "socket", nullable = false, length = 2147483647)
    private String socket;
    @OneToMany(mappedBy = "idSocket")
    private List<Motherboards> motherboardsList;
    @OneToMany(mappedBy = "idSocket")
    private List<Procesadores> procesadoresList;

    public Sockets() {
    }

    public Sockets(Integer idSocket) {
        this.idSocket = idSocket;
    }

    public Sockets(Integer idSocket, String socket) {
        this.idSocket = idSocket;
        this.socket = socket;
    }

    public Integer getIdSocket() {
        return idSocket;
    }

    public void setIdSocket(Integer idSocket) {
        this.idSocket = idSocket;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @XmlTransient
    public List<Motherboards> getMotherboardsList() {
        return motherboardsList;
    }

    public void setMotherboardsList(List<Motherboards> motherboardsList) {
        this.motherboardsList = motherboardsList;
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
        hash += (idSocket != null ? idSocket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sockets)) {
            return false;
        }
        Sockets other = (Sockets) object;
        if ((this.idSocket == null && other.idSocket != null) || (this.idSocket != null && !this.idSocket.equals(other.idSocket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Sockets[ idSocket=" + idSocket + " ]";
    }
    
}
