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
@Table(name = "soluciones", catalog = "soporte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soluciones.findAll", query = "SELECT s FROM Soluciones s")
    , @NamedQuery(name = "Soluciones.findByIdSolucion", query = "SELECT s FROM Soluciones s WHERE s.idSolucion = :idSolucion")
    , @NamedQuery(name = "Soluciones.findByNombre", query = "SELECT s FROM Soluciones s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Soluciones.findByDescripcion", query = "SELECT s FROM Soluciones s WHERE s.descripcion = :descripcion")})
public class Soluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solucion", nullable = false)
    private Integer idSolucion;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @JoinColumn(name = "id_tipo_mantenimiento", referencedColumnName = "id_tipo_mantenimiento")
    @ManyToOne
    private TiposMantenimiento idTipoMantenimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolucion")
    private List<DetallesOrdenTrabajo> detallesOrdenTrabajoList;

    public Soluciones() {
    }

    public Soluciones(Integer idSolucion) {
        this.idSolucion = idSolucion;
    }

    public Soluciones(Integer idSolucion, String nombre) {
        this.idSolucion = idSolucion;
        this.nombre = nombre;
    }

    public Integer getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(Integer idSolucion) {
        this.idSolucion = idSolucion;
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

    public TiposMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TiposMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    @XmlTransient
    public List<DetallesOrdenTrabajo> getDetallesOrdenTrabajoList() {
        return detallesOrdenTrabajoList;
    }

    public void setDetallesOrdenTrabajoList(List<DetallesOrdenTrabajo> detallesOrdenTrabajoList) {
        this.detallesOrdenTrabajoList = detallesOrdenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolucion != null ? idSolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soluciones)) {
            return false;
        }
        Soluciones other = (Soluciones) object;
        if ((this.idSolucion == null && other.idSolucion != null) || (this.idSolucion != null && !this.idSolucion.equals(other.idSolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sv.uesocc.entidades.Soluciones[ idSolucion=" + idSolucion + " ]";
    }
    
}
