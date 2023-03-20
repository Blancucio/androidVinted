/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import motores.MotorMySQL;

/**
 *
 * @author S2-PC00
 */
public class UsuarioDAO implements IDAO<Usuario,Integer>{
    
    //10 PROPIETARIOS CON MAS VENTAS
    private static final String SQL_PROPIETARIOS_MASVENTAS = "SELECT * FROM USUARIO,PRODUCTOS "
            + "WHERE USUARIO.ID_USUARIO=PRODUCTOS.ID_USUARIO "
            + "ORDER BY USUARIO.NUM_VENTAS DESC LIMIT 10;";
    
    
    private static final String SQL_INSERT = "INSERT INTO USUARIO VALUES ";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET ";
    private static final String SQL_DELETE = "DELETE FROM USUARIO WHERE ";
    private static final String SQL_FINDALL = "SELECT * FROM USUARIO";
    private MotorMySQL motorMySQL = null;



    public UsuarioDAO() {
        this.motorMySQL = new MotorMySQL();
    }
    

    @Override
    public int add(Usuario bean) {
       int resp = 0;
        try {
            motorMySQL.connect();

            String sql = SQL_INSERT + "('"
                    + bean.getNombre() + "', '"
                    + bean.getNumVentas()+");";

            resp = motorMySQL.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        if (resp > 0) {
            System.out.println("Usuario insertado con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario bean) {
        
        ArrayList<Usuario> usuarios = null;
        String sql = SQL_FINDALL;
        try {
            motorMySQL.connect();
            ResultSet rs = this.motorMySQL.executeQuery(SQL_FINDALL);

            if (rs != null) {
                usuarios = new ArrayList();

                while (rs.next()) {
                    Usuario usuario = new Usuario();

                    usuario.setIdUsuario(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setNumVentas(rs.getInt(3));

                    //producto.getUsuario().setIdUsuario(rs.getInt(9));

                    //System.out.println(producto.getIdProducto());
                    usuarios.add(usuario);

                }
            }
            this.motorMySQL.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuarios;

    }

    @Override
    public int update(Usuario bean) {
                int resp = 0;
        String sql;
        try {
            motorMySQL.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {
                sql = SQL_UPDATE;
                if (bean.getNombre() != null) {
                    sql += "NOMBRE='" + bean.getNombre() + "'";
                }
                if (bean.getNumVentas() != 0) {
                    sql += "PRECIO='" + bean.getNumVentas()+ "', ";
                }
                sql += " WHERE ID_USUARIO=" + bean.getIdUsuario() + ";";
                resp = motorMySQL.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorMySQL.disconnect();
        }

        if (resp > 0) {
            System.out.println("Usuario actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }
    
    
    public ArrayList<Usuario> usuarioMayorVentas(Usuario bean) {
    ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql= SQL_PROPIETARIOS_MASVENTAS;
                    
            
        try {
            motorMySQL.connect();
            ResultSet rs = motorMySQL.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setNumVentas(rs.getInt(3));

                

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return usuarios;
    }
    
}
