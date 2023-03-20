/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import model.producto.Producto;

/**
 *
 * @author S2-PC00
 */
public class CompraArrayList {
    // ATRIBUTES
    private ArrayList<Compra> listCompra;

    // CONSTRUCTOR
    public CompraArrayList(ArrayList<Compra> listCompra) {
        this.listCompra = new ArrayList<>();
        this.listCompra = listCompra;
    }

    public ArrayList<Compra> getListCompra() {
        return listCompra;
    }

    public void setLisCompra(ArrayList<Compra> listCompra) {
        this.listCompra = listCompra;
    }

    public String toArrayJSon() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(listCompra);

        return resp;
    }
}
