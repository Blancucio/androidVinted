package com.example.vinted.lst_MayorValoracion;

import com.example.vinted.entities.producto.Producto;

import java.util.ArrayList;

public interface LstProductoValContract {
    public interface View{
        void onSuccessLstProductoVal(ArrayList<Producto> lstProducto);
        void onFailureLstProductoVal(String err);
    }
    public interface Presenter{
        //Listado de los 10 restaurantes con más ventas.
        void lstProductoVal(Producto producto);
    }
    public interface Model{
        interface onLstProductoValListener{
            void onSuccess(ArrayList<Producto> lstProducto);
            void onFailure(String err);
        }
        void lstProductoWSVal(Producto producto, onLstProductoValListener onLstProductoValListener);
    }
}