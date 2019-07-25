/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.mb;

import com.fact.dao.ClientesDao;
import com.fact.dao.GenericDao;
import com.fact.dao.productoDao;
import com.fact.entities.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class productoMB implements Serializable {

    private Producto prodview;
    private List<Producto> prodList;
    @EJB
    private GenericDao gd;
    @EJB
    private productoDao pd;

    @PostConstruct
    public void init() {
        prodview = new Producto();
        prodList = new ArrayList<Producto>();
 //       mostrarClientes();
    }

    public void guardarClientes() {
        FacesMessage msg = null;
        Producto guardar = new Producto();
            guardar = (Producto) gd.insertarEntidad(guardar);

        if (null != guardar) {
            msg = new FacesMessage("Cliente guardado" + prodview.getIdProducto());
   //         mostrarClientes();
        } else {
            msg = new FacesMessage("error guardando");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
 //       mostrarClientes();
    }

//    public void mostrarClientes(){
//        clienList = cd.consultarCliente();
//    }

    public Producto getProdview() {
        return prodview;
    }

    public void setProdview(Producto prodview) {
        this.prodview = prodview;
    }

    public List<Producto> getProdList() {
        return prodList;
    }

    public void setProdList(List<Producto> prodList) {
        this.prodList = prodList;
    }
    

}
