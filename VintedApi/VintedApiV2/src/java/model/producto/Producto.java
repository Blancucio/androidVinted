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
public class Producto {

    private int idProducto;
    private String nombre;
    private String imagen;
    private String descripcion;
    private int precio;
    private String vendido;
    private int puntuacion;
    private String categoria;
    private Usuario usuario;

    //CREO CONSTRUCTORES DE USUARIOS
    public Producto() {
        this.usuario = new Usuario();
    }
    

    public Producto(int idProducto, String nombre, String imagen, String descripcion, int precio, String vendido, int puntuacion, String categoria, Usuario usuario) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.vendido = vendido;
        this.puntuacion = puntuacion;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    //GETTER Y SETTER
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getVendido() {
        return vendido;
    }

    public void setVendido(String vendido) {
        this.vendido = vendido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //TO STRING USUARIO
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public static String fromArrayListToJson(ArrayList<Producto> lstProducto) {
        String resp = "[";
        for (Producto producto : lstProducto) {
            resp += "{"
                    + "\"ID_PRODUCTO\":\"" + producto.getIdProducto() + "\", "
                    + "\"NOMBRE\":\"" + producto.getNombre() + "\","
                    + "\"IMAGEN\":\"" + producto.getImagen() + "\", "
                    + "\"DESCRIPCION\":\"" + producto.getDescripcion() + "\", "
                    + "\"PRECIO\":\"" + producto.getPrecio() + "\","
                    + "\"VENDIDO\":\"" + producto.getVendido() + "\","
                    + "\"PUNTUACION\":\"" + producto.getPuntuacion() + "\","
                    + "\"CATEGORIA\":\"" + producto.getCategoria() + "\","
                    + "\"ID_USUARIO\":\"" + producto.getUsuario().getIdUsuario()+ "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }
}
