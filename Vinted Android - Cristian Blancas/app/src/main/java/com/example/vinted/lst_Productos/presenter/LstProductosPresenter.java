package com.example.vinted.lst_Productos.presenter;


import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.lst_Productos.model.LstProductosModel;

import java.util.ArrayList;

public class LstProductosPresenter implements LstProductoContract.Presenter {

    private LstProductosModel lstProductosModel;
    private LstProductoContract.View view;

    public LstProductosPresenter(LstProductoContract.View view) {
        this.view = view;
        this.lstProductosModel = new LstProductosModel();
    }

    @Override
    public void lstProducto(Producto producto) {
        lstProductosModel.lstProductoWS(null, new LstProductoContract.Model.onLstProductoListener() {
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