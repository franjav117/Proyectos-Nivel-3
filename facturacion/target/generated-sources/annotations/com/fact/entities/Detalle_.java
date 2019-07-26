package com.fact.entities;

import com.fact.entities.DetallePK;
import com.fact.entities.Factura;
import com.fact.entities.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-26T10:12:35")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, BigDecimal> precio;
    public static volatile SingularAttribute<Detalle, Factura> factura;
    public static volatile SingularAttribute<Detalle, Integer> cantidad;
    public static volatile SingularAttribute<Detalle, Producto> idProducto;
    public static volatile SingularAttribute<Detalle, DetallePK> detallePK;

}