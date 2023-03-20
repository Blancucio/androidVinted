/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

/**
 *
 * @author S2-PC00
 */
public class Compra {
    
    private int idCompra;
    private int idUsuario;
    private int idProducto;
    private String email;
    private String notificacion;

    //CONSTRUCTOR
    public Compra() {
    }

    public Compra(int idCompra, int idUsuario, int idProducto, String email, String notificacion) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.email = email;
        this.notificacion = notificacion;
    }

    //GETTER AND SETTER
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", email=" + email + ", notificacion=" + notificacion + '}';
    }
    
    
    
}
