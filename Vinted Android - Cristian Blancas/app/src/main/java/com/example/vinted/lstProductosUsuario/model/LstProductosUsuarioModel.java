package com.example.vinted.lstProductosUsuario.model;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lstProductosUsuario.LstProductoUsuarioContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductosUsuarioModel  implements LstProductoUsuarioContract.Model{


    @Override
    public void lstProductoUsuarioWS(Producto producto, onLstProductoUsuarioListener onLstProductoUsuarioListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Producto>> call = apiService.getProductoUsuario(producto.getUsuario().getId_usuario());
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                ArrayList<Producto> listaProducto = response.body();
                onLstProductoUsuarioListener.onSuccess(listaProducto);
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                onLstProductoUsuarioListener.onFailure(t.getMessage());
            }
        });
    }
}
