/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author francisco.amayausam
 */
@Embeddable
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "num_detalle")
    private int numDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_factura")
    private int idFactura;

    public DetallePK() {
    }

    public DetallePK(int numDetalle, int idFactura) {
        this.numDetalle = numDetalle;
        this.idFactura = idFactura;
    }

    public int getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numDetalle;
        hash += (int) idFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if (this.numDetalle != other.numDetalle) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fact.entities.DetallePK[ numDetalle=" + numDetalle + ", idFactura=" + idFactura + " ]";
    }
    
}
