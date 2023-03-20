package com.example.vinted.lst_UsuariosVentas.model;

import com.example.vinted.entities.usuario.Usuario;
import com.example.vinted.lst_UsuariosVentas.LstUsuarioVentasContract;
import com.example.vinted.utils.ApiClient;
import com.example.vinted.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstUsuariosVentasModel implements LstUsuarioVentasContract.Model {

    @Override
    public void lstUsuarioVentasWS(Usuario usuario, onLstUsuarioVentasListener onLstUsuarioVentasListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Usuario>> call = apiService.getUsuario();
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                ArrayList<Usuario> listaUsuario = response.body();
                onLstUsuarioVentasListener.onSuccess(listaUsuario);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                onLstUsuarioVentasListener.onFailure(t.getMessage());
            }
        });
    }
}
