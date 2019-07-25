/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author francisco.amayausam
 */
@Entity
@Table(name = "modo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModoPago.findAll", query = "SELECT m FROM ModoPago m")
    , @NamedQuery(name = "ModoPago.findByNumPago", query = "SELECT m FROM ModoPago m WHERE m.numPago = :numPago")
    , @NamedQuery(name = "ModoPago.findByNombre", query = "SELECT m FROM ModoPago m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "ModoPago.findByOtrosDetalles", query = "SELECT m FROM ModoPago m WHERE m.otrosDetalles = :otrosDetalles")})
public class ModoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_pago")
    private Integer numPago;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 140)
    @Column(name = "otros_detalles")
    private String otrosDetalles;
    @OneToMany(mappedBy = "numPago")
    private List<Factura> facturaList;

    public ModoPago() {
    }

    public ModoPago(Integer numPago) {
        this.numPago = numPago;
    }

    public Integer getNumPago() {
        return numPago;
    }

    public void setNumPago(Integer numPago) {
        this.numPago = numPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOtrosDetalles() {
        return otrosDetalles;
    }

    public void setOtrosDetalles(String otrosDetalles) {
        this.otrosDetalles = otrosDetalles;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPago != null ? numPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModoPago)) {
            return false;
        }
        ModoPago other = (ModoPago) object;
        if ((this.numPago == null && other.numPago != null) || (this.numPago != null && !this.numPago.equals(other.numPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fact.entities.ModoPago[ numPago=" + numPago + " ]";
    }
    
}
