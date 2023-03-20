/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author S2-PC00
 */
public class UsuarioArrayList {
        // ATRIBUTES

    private ArrayList<Usuario> listUsuario;

    // CONSTRUCTOR
    public UsuarioArrayList(ArrayList<Usuario> listUsuario) {
        this.listUsuario = new ArrayList<>();
        this.listUsuario = listUsuario;
    }

    public ArrayList<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(ArrayList<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    
}
