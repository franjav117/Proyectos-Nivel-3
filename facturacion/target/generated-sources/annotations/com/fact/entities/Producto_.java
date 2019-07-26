package com.fact.entities;

import com.fact.entities.Categoria;
import com.fact.entities.Detalle;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-26T09:40:28")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, BigDecimal> precio;
    public static volatile ListAttribute<Producto, Detalle> detalleList;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;
    public static volatile SingularAttribute<Producto, String> nombre;

}