package com.example.vinted.lst_UsuariosVentas.presenter;

import com.example.vinted.entities.usuario.Usuario;
import com.example.vinted.lst_UsuariosVentas.LstUsuarioVentasContract;
import com.example.vinted.lst_UsuariosVentas.model.LstUsuariosVentasModel;

import java.util.ArrayList;

public class LstUsuariosVentasPresenter implements LstUsuarioVentasContract.Presenter {

    private LstUsuariosVentasModel lstUsuariosVentasModel;
    private LstUsuarioVentasContract.View view;

    public LstUsuariosVentasPresenter(LstUsuarioVentasContract.View view) {
        this.view = view;
        this.lstUsuariosVentasModel = new LstUsuariosVentasModel();
    }


    @Override
    public void LstUsuarioVentas(Usuario usuario) {
        lstUsuariosVentasModel.lstUsuarioVentasWS(null, new  LstUsuarioVentasContract.Model.onLstUsuarioVentasListener() {
            @Override
            public void onSuccess(ArrayList<Usuario> lstUsuario) {
                if (lstUsuario != null &&lstUsuario.size() > 0){
                    view.onSuccessLstUsuarioVentas(lstUsuario);
                } else {
                    view.onFailureLstUsuarioVentas("Error");
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureLstUsuarioVentas(err);
            }
        });
    }
}
