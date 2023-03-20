package com.example.vinted.lst_categoria.presenter;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_categoria.LstProductoCategoriaContract;
import com.example.vinted.lst_categoria.model.LstProductosCategoriaModel;

import java.util.ArrayList;

public class LstProductosCategoriaPresenter implements LstProductoCategoriaContract.Presenter {

    private LstProductosCategoriaModel lstProductosCategoriaModel;
    private LstProductoCategoriaContract.View view;

    public LstProductosCategoriaPresenter(LstProductoCategoriaContract.View view) {
        this.view = view;
        this.lstProductosCategoriaModel = new LstProductosCategoriaModel();
    }

    @Override
    public void lstProducto(Producto producto) {

        lstProductosCategoriaModel.lstProductoCategoriaWS(producto, new LstProductoCategoriaContract.Model.onLstProductoListener() {
            @Override
            public void onSuccess(ArrayList<Producto> lstProducto) {
                if (lstProducto != null &&lstProducto.size() > 0){
                    view.onSuccessLstProducto(lstProducto);
                } else {
                    view.onSuccessLstProducto(lstProducto);
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureLstProducto(err);
            }

        });
    }

}
