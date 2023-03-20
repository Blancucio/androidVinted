package com.example.vinted.lst_Productos;

import com.example.vinted.entities.producto.Producto;

import java.util.ArrayList;

public interface LstProductoContract {
    public interface View{
        void onSuccessLstProducto(ArrayList<Producto> lstProducto);
        void onFailureLstProducto(String err);
    }
    public interface Presenter{
        void lstProducto(Producto producto);
    }
    public interface Model{
        interface onLstProductoListener{
            void onSuccess(ArrayList<Producto> lstProducto);
            void onFailure(String err);
        }
        void lstProductoWS(Producto producto, onLstProductoListener onLstProductoListener);
    }
}