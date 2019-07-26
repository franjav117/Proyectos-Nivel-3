package com.fact.entities;

import com.fact.entities.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-26T09:40:27")
@StaticMetamodel(ModoPago.class)
public class ModoPago_ { 

    public static volatile SingularAttribute<ModoPago, String> otrosDetalles;
    public static volatile SingularAttribute<ModoPago, Integer> numPago;
    public static volatile ListAttribute<ModoPago, Factura> facturaList;
    public static volatile SingularAttribute<ModoPago, String> nombre;

}