package com.example.vinted.lst_Productos.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;

import java.util.ArrayList;

public class LstProductosModel implements LstProductoContract.Model {

    @Override
    public void lstProductoWS(Producto producto, onLstProductoListener onLstProductoListenerr) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Producto>> call = apiService.getProducto();
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                ArrayList<Producto> listaProducto = response.body();
                onLstProductoListenerr.onSuccess(listaProducto);
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                onLstProductoListenerr.onFailure(t.getMessage());
            }
        });
    }
}
