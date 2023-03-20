package com.example.vinted.lst_MayorValoracion.model;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_MayorValoracion.LstProductoValContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstProductosValModel implements LstProductoValContract.Model {

    @Override
    public void lstProductoWSVal(Producto producto, onLstProductoValListener onLstProductoValListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Producto>> call = apiService.getProductoValoracion();
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                ArrayList<Producto> listaProducto = response.body();
                onLstProductoValListener.onSuccess(listaProducto);
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                onLstProductoValListener.onFailure(t.getMessage());
            }
        });
    }
}
