package com.example.vinted.lstProductosUsuario.presenter;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lstProductosUsuario.LstProductoUsuarioContract;
import com.example.vinted.lstProductosUsuario.model.LstProductosUsuarioModel;

import java.util.ArrayList;

public class LstProductosUsuarioPresenter implements LstProductoUsuarioContract.Presenter{

    private LstProductosUsuarioModel lstProductosUsuariosModel;
    private LstProductoUsuarioContract.View view;

    public LstProductosUsuarioPresenter(LstProductoUsuarioContract.View view) {
        this.view = view;
        this.lstProductosUsuariosModel = new LstProductosUsuarioModel();
    }

    @Override
    public void lstProducto(Producto producto) {

        lstProductosUsuariosModel.lstProductoUsuarioWS(producto, new LstProductoUsuarioContract.Model.onLstProductoUsuarioListener() {
            @Override
            public void onSuccess(ArrayList<Producto> lstProducto) {
                if (lstProducto != null &&lstProducto.size() > 0){
                    view.onSuccessLstProductoUsuario(lstProducto);
                } else {
                    //view.onFailureLstProductoUsuario(String err);
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureLstProductoUsuario(err);
            }
        });
    }
}
