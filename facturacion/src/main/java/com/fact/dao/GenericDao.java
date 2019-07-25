/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francisco.amayausam
 */
@Stateless
public class GenericDao {

    EntityManagerFactory f = Persistence.createEntityManagerFactory("facturacionPU");//nombre de la persistencia
    EntityManager em = f.createEntityManager();

    public Object insertarEntidad(Object obj) {

        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
        return obj;
    }

    public String actualizarEntidad(Object obj) {
        String mensaje = "";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            mensaje = "Actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            mensaje = "Error actualizando datos";
        }
        return mensaje;
    }

}
