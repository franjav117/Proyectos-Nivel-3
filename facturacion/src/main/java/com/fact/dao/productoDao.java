/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import com.fact.entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francisco.amayausam
 */
@Stateless
public class productoDao {
    @PersistenceContext(unitName = "facturacionPU")
    
    private EntityManager em;
    private List<Producto> producList;
    private Producto prodao;
    
    public List<Producto> consultarProducto(){
        try {
            producList = new ArrayList<Producto>();
            producList = em.createNamedQuery("Producto.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producList;
    }
    
    public Producto findProductoById(Producto provist){
        try {
            prodao = new Producto();
            prodao = (Producto) em.createNamedQuery("Producto.findByIdProducto").setParameter("idProducto", provist.getIdProducto()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prodao;
    }

    public String eliminarProducto(Producto prodel) {
        String mensaje = "";
        try {
            System.out.println("eliminado desde la vista "+prodel.getIdProducto());
            em.remove(em.find(Producto.class,prodel.getIdProducto()));
            mensaje = "eliminado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "error eliminando";
        }
        return mensaje;
    }
    
}
