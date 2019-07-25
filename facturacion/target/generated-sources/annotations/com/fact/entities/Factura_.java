package com.fact.entities;

import com.fact.entities.Cliente;
import com.fact.entities.Detalle;
import com.fact.entities.ModoPago;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-24T14:37:50")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, Cliente> idCliente;
    public static volatile SingularAttribute<Factura, ModoPago> numPago;
    public static volatile ListAttribute<Factura, Detalle> detalleList;
    public static volatile SingularAttribute<Factura, Integer> numFactura;

}