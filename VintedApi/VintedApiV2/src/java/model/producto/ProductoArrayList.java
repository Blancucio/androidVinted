/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import model.usuario.Usuario;

/**
 *
 * @author S2-PC00
 */
public class ProductoArrayList {
    // ATRIBUTES
    private ArrayList<Producto> listProducto;

    // CONSTRUCTOR
    public ProductoArrayList(ArrayList<Producto> listProducto) {
        this.listProducto = new ArrayList<>();
        this.listProducto = listProducto;
    }

    public ArrayList<Producto> getListProducto() {
        return listProducto;
    }

    public void setListUsuario(ArrayList<Producto> listProducto) {
        this.listProducto = listProducto;
    }


}
