package com.example.vinted.utils;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.entities.usuario.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("listarProductos")
    Call<ArrayList<Producto>> getProducto();

    @GET("lstProductosVer/lstProductosVer/{id}")
    Call<ArrayList<Producto>> getProductoVer(@Path("id") int id);

    @GET("lstProductosUsuario/lstProductosUsuario/{id}")
    Call<ArrayList<Producto>> getProductoUsuario(@Path("id") int id);

    @GET("Llistar10ProductosValoracion")
    Call<ArrayList<Producto>> getProductoValoracion();


    @GET("listarUsuariosVentas")
    Call<ArrayList<Usuario>> getUsuario();

    @GET("crearProductos/crearProductos/{nombre}/{categoria}/{descripcion}/{precio}/{puntuacion}/{usuario}")
    Call<ArrayList<Producto>> insertProducto(@Path("nombre") String nombre, @Path("categoria") String categoria, @Path("descripcion") String descripcion, @Path("precio") String precio, @Path("puntuacion") String puntuacion, @Path("usuario") String usuario);

    //Poner el put para que pase 1 id


    //@GET("listarProductoCategoria/listarProductoCategoria/{categoria}")
    //Call<ArrayList<Producto>> getFiltroCategoria(@Path("categoria") String categoria);

    @GET("listarProductoCategoria/listarProductoCategoria/{categoria}/{nombre}")
    Call<ArrayList<Producto>> getFiltroCategoria(@Path("categoria") String categoria, @Path("nombre") String nombre);

}