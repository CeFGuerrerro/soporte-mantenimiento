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
@Table(name = "procesadores", catalog = "soporte", schema = "USUARIO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesadores.findAll", query = "SELECT p FROM Procesadores p")
    , @NamedQuery(name = "Procesadores.findByIdProcesador", query = "SELECT p FROM Procesadores p WHERE p.idProcesador = :idProcesador")
    , @NamedQuery(name = "Procesadores.findByNumeroSerie", query = "SELECT p FROM Procesadores p WHERE p.numeroSerie = :numeroSerie")})
public class Procesadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procesador", nullable = false)
    private Integer idProcesador;
    @Column(name = "numero_serie", length = 2147483647)
    private String numeroSerie;
    @JoinColumn(name = "id_arquitectura", referencedColumnName = "id_arquitectura", nullable = false)
    @ManyToOne(optional = false)
    private Arquitecturas idArquitectura;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelos idModelo;
    @JoinColumn(name = "id_socket", referencedColumnName = "id_socket")
    @ManyToOne
    private Sockets idSocket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesador")
    private List<HardwareComponente> hardwareComponenteList;

    public Procesadores() {
    }

    public Procesadores(Integer idProcesador) {
        this.idProcesador = idProcesador;
    }

    public Integer getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Integer idProcesador) {
        this.idProcesador = idProcesador;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Arquitecturas getIdArquitectura() {
        return idArquitectura;
    }

    public void setIdArquitectura(Arquitecturas idArquitectura) {
        this.idArquitectura = idArquitectura;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    public Sockets getIdSocket() {
        return idSocket;
    }

    public void setIdSocket(Sockets idSocket) {
        this.idSocket = idSocket;
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
        hash += (idProcesador != null ? idProcesador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesadores)) {
            return false;
        }
        Procesadores other = (Procesadores) object;
        if ((this.idProcesador == null && other.idProcesador != null) || (this.idProcesador != null && !this.idProcesador.equals(other.idProcesador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Procesadores[ idProcesador=" + idProcesador + " ]";
    }
    
}
