package com.example.vinted.ver_prenda;

import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;

import java.util.ArrayList;

public interface PrendaContract {
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
        void lstProductoWS(Producto producto, LstProductoContract.Model.onLstProductoListener onLstProductoListener);
    }
}
