package com.example.vinted.lst_MayorValoracion.presenter;


import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_MayorValoracion.LstProductoValContract;
import com.example.vinted.lst_MayorValoracion.model.LstProductosValModel;

import java.util.ArrayList;

public class LstProductosValPresenter implements LstProductoValContract.Presenter {

    private LstProductosValModel lstProductosValModel;
    private LstProductoValContract.View view;

    public LstProductosValPresenter(LstProductoValContract.View view) {
        this.view = view;
        this.lstProductosValModel = new LstProductosValModel();
    }

    @Override
    public void lstProductoVal(Producto producto) {
        lstProductosValModel.lstProductoWSVal(null, new LstProductoValContract.Model.onLstProductoValListener() {
            @Override
            public void onSuccess(ArrayList<Producto> lstProducto) {
                if (lstProducto != null &&lstProducto.size() > 0){
                    view.onSuccessLstProductoVal(lstProducto);
                } else {
                    view.onSuccessLstProductoVal(lstProducto);
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureLstProductoVal(err);
            }
        });
    }

}