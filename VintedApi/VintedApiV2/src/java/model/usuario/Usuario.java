package model.usuario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;


public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private int numVentas;

    //CREO CONSTRUCTORES DE USUARIOS
    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, int numVentas) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.numVentas = numVentas;
    }

    //GETTER Y SETTER
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    //TO STRING USUARIO
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", numVentas=" + numVentas + '}';
    }

    
    
    public static String fromArrayListToJson(ArrayList<Usuario> lstUsuario) {
        String resp = "[";
        for (Usuario usuario : lstUsuario) {
            resp += "{"
                    + "\"ID_USUARIO\":\"" + usuario.getIdUsuario() + "\", "
                    + "\"NOMBRE\":\"" + usuario.getNombre() + "\","
                    + "\"NUM_VENTAS\":" + usuario.getNumVentas() + "}";

            //+ "\"ID_USUARIO\":\"" + producto.getUsuario().getIdUsuario()+ "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }

}
