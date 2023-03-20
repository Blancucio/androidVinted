/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.compra;

import interfaces.IDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.producto.Producto;
import motores.MotorMySQL;

/**
 *
 * @author S2-PC00
 */
public class CompraDAO implements IDAO<Compra, Integer> {
    
    //HISTORICO DE COMPRAS
    private static final String SQL_SELECT = "SELECT * FROM COMPRA WHERE 1=1;";   
    
    private static final String SQL_INSERT = "INSERT INTO COMPRA VALUES (ID_USUARIO, ID_PRODUCTO, EMAIL, NOTIFICACION) VALUES";

    private static final String SQL_UPDATE = "UPDATE USUARIO SET ";
    private static final String SQL_DELETE = "DELETE FROM USUARIO WHERE ";
    
    private MotorMySQL motorMySQL = null;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CompraDAO(HttpServletRequest request, 
                            HttpServletResponse response) {
        this.motorMySQL = new MotorMySQL();
        this.request = request;
        this.response = response;
        
    }

    @Override
    public int add(Compra bean) {
       int resp = 0;
        try {
            motorMySQL.connect();

            String sql = SQL_INSERT + "('"
                    + bean.getIdUsuario() + "', '"
                    + bean.getIdProducto()+ "', '"
                    + bean.getEmail()+ "', '"
                    + bean.getNotificacion()+");";

            resp = motorMySQL.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        if (resp > 0) {
            System.out.println("Compra insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compra> findAll(Compra bean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Compra bean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
