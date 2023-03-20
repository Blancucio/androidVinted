package com.example.vinted.ver_prenda.model;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;
import com.example.vinted.ver_prenda.PrendaContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstPrendaModel implements PrendaContract.Model{
    @Override
    public void lstProductoWS(Producto producto, LstProductoContract.Model.onLstProductoListener onLstProductoListenerr) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Producto>> call = apiService.getProductoVer(producto.getId_Producto());
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
