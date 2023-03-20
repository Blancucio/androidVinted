package com.example.vinted.entities.producto;

import com.example.vinted.entities.usuario.Usuario;
import com.google.gson.annotations.SerializedName;

public class Producto {
    @SerializedName("ID_PRODUCTO")
    private int id_Producto;
    @SerializedName("NOMBRE")
    private String nombre;
    @SerializedName("IMAGEN")
    private String imagen;
    @SerializedName("DESCRIPCION")
    private String descripcion;
    @SerializedName("PRECIO")
    private int precio;
    @SerializedName("VENDIDO")
    private String vendido;
    @SerializedName("PUNTUACION")
    private int puntuacion;
    @SerializedName("CATEGORIA")
    private String categoria;
    @SerializedName("USUARIO")
    private Usuario usuario;

    public Producto() {
        this.usuario = new Usuario();
    }

    public Producto(int id_producto, String nombre, String imagen, String descripcion,
                    int precio, String vendido, int puntuacion, String categoria, Usuario usuario) {
        this.id_Producto = id_producto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.vendido = vendido;
        this.puntuacion = puntuacion;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
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
}
