package com.example.vinted.lst_categoria;

import com.example.vinted.entities.producto.Producto;

import java.util.ArrayList;

public interface LstProductoCategoriaContract {
    public interface View{
        void onSuccessLstProducto(ArrayList<Producto> lstProducto);
        void onFailureLstProducto(String err);
    }
    public interface Presenter{
        //Listado de los restaurantes por las necesidades del cliente
        void lstProducto(Producto producto);
    }
    public interface Model{
        interface onLstProductoListener{
            void onSuccess(ArrayList<Producto> lstProducto);
            void onFailure(String err);
        }
        void lstProductoCategoriaWS(Producto producto, onLstProductoListener onLstProductoListener);
    }
}
