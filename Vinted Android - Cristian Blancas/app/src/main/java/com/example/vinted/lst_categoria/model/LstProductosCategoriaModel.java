package com.example.vinted.lst_categoria.model;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_categoria.LstProductoCategoriaContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductosCategoriaModel implements LstProductoCategoriaContract.Model {

    @Override
    public void lstProductoCategoriaWS(Producto producto, onLstProductoListener onLstProductoListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Producto>> call = apiService.getFiltroCategoria(producto.getCategoria(), producto.getNombre());
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                ArrayList<Producto> listaProducto = response.body();
                onLstProductoListener.onSuccess(listaProducto);
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                onLstProductoListener.onFailure(t.getMessage());
            }
        });
    }

}
