package com.example.vinted.crearProducto.presenter;

import com.example.vinted.crearProducto.crearProductoContract;
import com.example.vinted.crearProducto.model.crearProductoModel;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_categoria.LstProductoCategoriaContract;
import com.example.vinted.lst_categoria.model.LstProductosCategoriaModel;

import java.util.ArrayList;

public class crearProductoPresenter implements crearProductoContract.Presenter{

    private crearProductoModel lstCrearProductoModel;
    private crearProductoContract.View view;

    public crearProductoPresenter(crearProductoContract.View view) {
        this.lstCrearProductoModel = new crearProductoModel();
        this.view = view;
    }

    @Override
    public void lstProducto(Producto producto) {
        lstCrearProductoModel.lstProductoCategoriaWS(producto, new crearProductoContract.Model.onLstProductoListener() {
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

            }
        });
    }
}
