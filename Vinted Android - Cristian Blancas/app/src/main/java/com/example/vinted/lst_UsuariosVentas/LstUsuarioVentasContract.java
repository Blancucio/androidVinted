package com.example.vinted.lst_UsuariosVentas;

import com.example.vinted.entities.usuario.Usuario;

import java.util.ArrayList;

public interface LstUsuarioVentasContract {
    public interface View{
        void onSuccessLstUsuarioVentas(ArrayList<Usuario> lstUsuario);
        void onFailureLstUsuarioVentas(String err);
    }
    public interface Presenter{
        //Listado de los 10 restaurantes con más ventas.
        void LstUsuarioVentas(Usuario usuario);
    }
    public interface Model{
        interface onLstUsuarioVentasListener{
            void onSuccess(ArrayList<Usuario> lstUsuario);
            void onFailure(String err);
        }
        void lstUsuarioVentasWS(Usuario usuario, onLstUsuarioVentasListener onLstUsuarioVentasListener);
    }
}
