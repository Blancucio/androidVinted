package com.example.vinted.ver_prenda.presenter;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.lst_Productos.model.LstProductosModel;
import com.example.vinted.ver_prenda.PrendaContract;
import com.example.vinted.ver_prenda.model.LstPrendaModel;

import java.util.ArrayList;

public class LstPrendaPresenter implements PrendaContract.Presenter {

    private LstPrendaModel lstProductosModel;
    private PrendaContract.View view;

    public LstPrendaPresenter(PrendaContract.View view) {
        this.view = view;
        this.lstProductosModel = new LstPrendaModel();
    }

    @Override
    public void lstProducto(Producto producto) {
        lstProductosModel.lstProductoWS(producto, new LstProductoContract.Model.onLstProductoListener() {
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
