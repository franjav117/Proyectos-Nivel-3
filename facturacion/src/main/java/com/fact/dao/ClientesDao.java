/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import com.fact.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
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
public class ClientesDao {    

    EntityManagerFactory f = Persistence.createEntityManagerFactory("facturacionPU");//nombre de la persistencia
    EntityManager em = f.createEntityManager();

    private List<Cliente> listCliD;
    private Cliente clienteDao;

    public List<Cliente> consultarCliente() {  //Devuelve la lista completa
        try {
            listCliD = new ArrayList<Cliente>();
            listCliD = em.createNamedQuery("Cliente.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCliD;
    }

    public Cliente findClienteById(Cliente clivist) { //Seleccionar Cliente Individual por ID
        try {
            clienteDao = new Cliente();
            clienteDao = (Cliente) em.createNamedQuery("Cliente.findByIdCliente").setParameter("idCliente", clivist.getIdCliente()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clienteDao;
    }

    public String eliminarCliente(Cliente clidel) {   //Eliminar cliente
        String mensaje = "";
        try {
            System.out.println("eliminado desde la vista " + clidel.getIdCliente());
            em.getTransaction().begin();
            em.remove(em.find(Cliente.class, clidel.getIdCliente()));
            em.getTransaction().commit();
            mensaje = "eliminado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            mensaje = "error eliminando";
        }
        return mensaje;
    }
}
