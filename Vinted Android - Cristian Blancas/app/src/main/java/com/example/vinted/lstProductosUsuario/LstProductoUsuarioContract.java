package com.example.vinted.lstProductosUsuario;

import com.example.vinted.entities.producto.Producto;

import java.util.ArrayList;

public interface LstProductoUsuarioContract {

    public interface View{
        void onSuccessLstProductoUsuario(ArrayList<Producto> lstProducto);
        void onFailureLstProductoUsuario(String err);
    }

    public interface Presenter{
        void lstProducto(Producto producto);
    }

    public interface Model{
        interface onLstProductoUsuarioListener{
            void onSuccess(ArrayList<Producto> lstProducto);
            void onFailure(String err);
        }
        void lstProductoUsuarioWS(Producto producto, onLstProductoUsuarioListener onLstProductoUsuarioListener);
    }
}
