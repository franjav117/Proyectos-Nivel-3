/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.mb;

import com.fact.dao.ClientesDao;
import com.fact.dao.GenericDao;
import com.fact.entities.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author francisco.amayausam
 */
@ManagedBean
@ViewScoped
//@javax.faces.view.ViewScoped
public class clientesMB implements Serializable {

    private Cliente clienteVist;
    private List<Cliente> clienList;
    private GenericDao gd;
    private ClientesDao cd;

    @PostConstruct
    public void init() {
        clienteVist = new Cliente();
        clienList = new ArrayList<Cliente>();
        gd = new GenericDao();
        cd = new ClientesDao();
        mostrarClientes();
    }

    public void guardarClientes() {
        FacesMessage msg = null;

        clienteVist = (Cliente) gd.insertarEntidad(clienteVist);
        if (null != clienteVist) {
            msg = new FacesMessage("Cliente guardado" + clienteVist.getIdCliente());
            clienteVist = new Cliente();
            mostrarClientes();
        } else {
            msg = new FacesMessage("error guardando");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        mostrarClientes();
    }

    public void actualizarClientes() {
        String msg = null;
        try {
            msg = gd.actualizarEntidad(clienteVist);
            clienteVist = new Cliente();
            mostrarClientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FacesMessage mensaje = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        mostrarClientes();
    }

    public void eliminarCliente(Cliente Cli) {
        String mensaje = cd.eliminarCliente(Cli);
        mostrarClientes();
        FacesMessage msg = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectClienteActual(Cliente Cli) {
        try {
            clienteVist = new Cliente();
            clienteVist = cd.findClienteById(Cli);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientes() {
        clienList = cd.consultarCliente();
    }

    public Cliente getClienteVist() {
        return clienteVist;
    }

    public void setClienteVist(Cliente clienteVist) {
        this.clienteVist = clienteVist;
    }

    public List<Cliente> getClienList() {
        return clienList;
    }

    public void setClienList(List<Cliente> clienList) {
        this.clienList = clienList;
    }

    public GenericDao getGd() {
        return gd;
    }

    public void setGd(GenericDao gd) {
        this.gd = gd;
    }

    public ClientesDao getCd() {
        return cd;
    }

    public void setCd(ClientesDao cd) {
        this.cd = cd;
    }

}
