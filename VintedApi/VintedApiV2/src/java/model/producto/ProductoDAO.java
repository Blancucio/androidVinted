/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import motores.MotorMySQL;

/**
 *
 * @author S2-PC00
 */
public class ProductoDAO implements IDAO<Producto, Integer> {

    //INSERTAR PRODUCTO 
    private static final String SQL_INSERTAR_PRODUCTO = "INSERT INTO PRODUCTOS "
            + "(NOMBRE, IMAGEN, DESCRIPCION, PRECIO, VENDIDO, PUNTUACION, CATEGORIA, ID_USUARIO) VALUES ";

    //LISTADO DE MIS PRODUCTOS A LA VENTA
    private static final String SQL_PRODUCTOS_VENTA = "SELECT productos.ID_PRODUCTO, productos.NOMBRE, productos.IMAGEN, productos.DESCRIPCION,"
            + "productos.PRECIO,productos.VENDIDO,productos.PUNTUACION,productos.CATEGORIA "
            + "FROM PRODUCTOS WHERE ";

    //10 PRODUCTOS CON MAS PUNTUACION
    private static final String SQL_MAYOR_PUNTUACION = "SELECT * FROM productos ORDER BY productos.PUNTUACION DESC LIMIT 10;";

    //FILTRADO EN FUNCION DE LAS NECESIDADES DEL USUARIO
    //TERMINAR GET CATEGORIA
    private static final String SQL_FILTAR_CATEGORIA = "SELECT productos.ID_PRODUCTO, productos.NOMBRE, productos.IMAGEN, productos.DESCRIPCION, productos.PRECIO, productos.VENDIDO, productos.PUNTUACION, productos.CATEGORIA "
            + "FROM productos";

    //FILTRADO EN FUNCION DE LAS NECESIDADES DEL USUARIO
    //TERMINAR GET CATEGORIA
    private static final String SQL_FILTAR_NOMBRE = "SELECT productos.ID_PRODUCTO, productos.NOMBRE, productos.IMAGEN, productos.DESCRIPCION, productos.PRECIO, productos.VENDIDO, productos.PUNTUACION, productos.CATEGORIA "
            + "FROM productos WHERE ";

    //LISTADO EN FUNCION DE LAS OPCIONES FILTRADAS
    private static final String SQL_FILTAR_AMBAS = "SELECT  productos.ID_PRODUCTO, productos.NOMBRE, productos.IMAGEN, productos.DESCRIPCION, productos.PRECIO, productos.VENDIDO, productos.PUNTUACION, productos.CATEGORIA "
            + "FROM productos WHERE ";

    //BUSCAR TODOS LOS PRODUCTOS
    private static final String SQL_FINDALL = "SELECT * FROM productos WHERE 1=1";

    private static final String SQL_UPDATE = "UPDATE productos SET ";

    //BORRAR UN PRODCUTO
    private static final String SQL_DELETE = "DELETE FROM productos WHERE productos.ID_PRODUCTO=";
    
    //SELECCIONAR 1 PRODUCTO
     private static final String SQL_FIND1= "SELECT * FROM `productos` WHERE ";
    

    private MotorMySQL motorMySQL = null;

    public ProductoDAO() {
        this.motorMySQL = new MotorMySQL();
    }

    @Override
    public int add(Producto bean) {
        int resp = 0;
        try {
            motorMySQL.connect();

            String sql = SQL_INSERTAR_PRODUCTO + "('"
                    + bean.getNombre() + "', '"
                    + bean.getImagen() + "', '"
                    + bean.getDescripcion() + "', '"
                    + bean.getPrecio() + "', '"
                    + bean.getVendido() + "', '"
                    + bean.getPuntuacion() + "', '"
                    + bean.getCategoria() + "', '"
                    + bean.getUsuario().getIdUsuario() + "');";

            resp = motorMySQL.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        if (resp > 0) {
            System.out.println("Producto insertado con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        motorMySQL.connect();
        try {
            String sql = SQL_DELETE + id;
            //desactivo la restriccion de claves foráneas para borrado
            motorMySQL.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorMySQL.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorMySQL.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Producto bean) {
        int resp = 0;
        String sql;
        try {
            motorMySQL.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getNombre() != null) {
                    sql += "NOMBRE='" + bean.getNombre() + "', ";
                }

                if (bean.getImagen() != null) {
                    sql += "IMAGEN='" + bean.getImagen() + "', ";
                }

                if (bean.getDescripcion() != null) {
                    sql += "DESCRIPCION='" + bean.getDescripcion() + "', ";
                }

                if (bean.getPrecio() > 0) {
                    sql += "PRECIO='" + bean.getPrecio() + "', ";
                }

                if (bean.getVendido() != null) {
                    sql += "VENDIDO='" + bean.getVendido() + "', ";
                }

                if (bean.getPuntuacion() > 0) {
                    sql += "PUNTUACION='" + bean.getPuntuacion() + "', ";
                }

                if (bean.getCategoria() != null) {
                    sql += "CATEGORIA='" + bean.getCategoria() + "'";
                }

                sql += " WHERE ID_Producto=" + bean.getUsuario().getIdUsuario() + ";";
                resp = motorMySQL.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorMySQL.disconnect();
        }

        if (resp > 0) {
            System.out.println("Producto actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    @Override
    public ArrayList<Producto> findAll(Producto bean) {

        ArrayList<Producto> productos = null;
        String sql = SQL_FINDALL;
        try {
            motorMySQL.connect();
            ResultSet rs = this.motorMySQL.executeQuery(sql);

            if (rs != null) {
                productos = new ArrayList();

                while (rs.next()) {
                    //Usuario usr = new Usuario();
                    Producto producto = new Producto();

                    producto.setIdProducto(rs.getInt(1));
                    producto.setNombre(rs.getString(2));
                    producto.setImagen(rs.getString(3));
                    producto.setDescripcion(rs.getString(4));
                    producto.setPrecio(rs.getInt(5));
                    producto.setVendido(rs.getString(6));
                    producto.setPuntuacion(rs.getInt(7));
                    producto.setCategoria(rs.getString(8));
                    producto.getUsuario().setIdUsuario(rs.getInt(9));

                    //System.out.println(producto.getIdProducto());
                    productos.add(producto);

                }
            }
            this.motorMySQL.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productos;
    }

    public ArrayList<Producto> mayorPuntuacion(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = SQL_MAYOR_PUNTUACION;
        try {
            motorMySQL.connect();

            ResultSet rs = motorMySQL.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                producto.setVendido(rs.getString(6));
                producto.setPuntuacion(rs.getInt(7));
                producto.setCategoria(rs.getString(8));
                producto.getUsuario().setIdUsuario(rs.getInt(9));

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return productos;
    }

    public ArrayList<Producto> productosVenta(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = SQL_PRODUCTOS_VENTA;
        String sql_filtro = "";
        String sql_final = "";
        try {
            motorMySQL.connect();

            if (bean.getUsuario().getIdUsuario() != 0) {
                sql_filtro += "productos.ID_USUARIO=\"" + bean.getUsuario().getIdUsuario() + "\""; //al ser un int cuidado con las comillas formato!!!!!!
            }
            sql_final = sql + sql_filtro;

            ResultSet rs = motorMySQL.executeQuery(sql_final);

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                producto.setVendido(rs.getString(6));
                producto.setPuntuacion(rs.getInt(7));
                producto.setCategoria(rs.getString(8));
                //producto.getUsuario().setIdUsuario(rs.getInt(9));
                
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return productos;
    }

    public ArrayList<Producto> findCategoria(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = SQL_FILTAR_CATEGORIA;
        String sql_filtro = "";
        String sql_final = "";
        try {
            motorMySQL.connect();
            if (bean.getCategoria() != null ) {
                sql_filtro += " WHERE productos.CATEGORIA='" + bean.getCategoria() + "'";
                if(bean.getNombre() != null) {
                    sql_filtro += " AND productos.NOMBRE LIKE '%" + bean.getNombre()+ "%'";
                }
            }
            if (bean.getCategoria() == null && bean.getNombre() != null) {
                    sql_filtro += " WHERE productos.NOMBRE LIKE '%" + bean.getNombre()+ "%'";
                }
  
            sql_final = sql + sql_filtro;

            ResultSet rs = motorMySQL.executeQuery(sql_final);

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                producto.setVendido(rs.getString(6));
                producto.setPuntuacion(rs.getInt(7));
                producto.setCategoria(rs.getString(8));
                //producto.getUsuario().setIdUsuario(rs.getInt(9));
                
                productos.add(producto);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return productos;
    }

    public ArrayList<Producto> findNombre(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = SQL_FILTAR_NOMBRE;
        String sql_filtro = "";
        String sql_final = "";
        try {
            motorMySQL.connect();
            if (bean != null) {
                if (bean.getNombre() != null) {
                    sql_filtro += "productos.NOMBRE LIKE '%" + bean.getNombre() + "%'";
                }
            }
            sql_final = sql + sql_filtro;

            ResultSet rs = motorMySQL.executeQuery(sql_final);

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                producto.setVendido(rs.getString(6));
                producto.setPuntuacion(rs.getInt(7));
                producto.setCategoria(rs.getString(8));
                //producto.getUsuario().setIdUsuario(rs.getInt(9));

                productos.add(producto);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return productos;
    }

    public ArrayList<Producto> findaAmbosFiltros(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = SQL_FILTAR_AMBAS;
        String sql_filtro = "";
        String sql_final = "";
        try {
            motorMySQL.connect();
            if (bean != null) {
                sql_filtro += "productos.CATEGORIA='" + bean.getCategoria() + "'"; //al ser un int cuidado con las comillas formato!!!!!!

                sql_filtro += " AND productos.NOMBRE LIKE '%" + bean.getNombre() + "%';";

            }
            sql_final = sql + sql_filtro;

            ResultSet rs = motorMySQL.executeQuery(sql_final);

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setImagen(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getInt(5));
                producto.setVendido(rs.getString(6));
                producto.setPuntuacion(rs.getInt(7));
                producto.setCategoria(rs.getString(8));
                //producto.getUsuario().setIdUsuario(rs.getInt(9));

                productos.add(producto);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorMySQL.disconnect();
        }
        return productos;
    }
    
    public ArrayList<Producto> find1(Producto bean) {

        ArrayList<Producto> productos = null;
        String sql = SQL_FIND1;
        String sql_filtro = "";
        String sql_final = "";
        try {
            motorMySQL.connect();
            
            if (bean.getIdProducto() != 0) {
                sql_filtro += "ID_PRODUCTO='" + bean.getIdProducto() + "'"; 
            }
            sql_final = sql + sql_filtro;
            
            ResultSet rs = this.motorMySQL.executeQuery(sql_final);

            if (rs != null) {
                productos = new ArrayList();

                while (rs.next()) {
                    //Usuario usr = new Usuario();
                    Producto producto = new Producto();

                    producto.setIdProducto(rs.getInt(1));
                    producto.setNombre(rs.getString(2));
                    producto.setImagen(rs.getString(3));
                    producto.setDescripcion(rs.getString(4));
                    producto.setPrecio(rs.getInt(5));
                    producto.setVendido(rs.getString(6));
                    producto.setPuntuacion(rs.getInt(7));
                    producto.setCategoria(rs.getString(8));
                    producto.getUsuario().setIdUsuario(rs.getInt(9));

                    //System.out.println(producto.getIdProducto());
                    productos.add(producto);

                }
            }
            this.motorMySQL.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productos;
    }
    
    public ArrayList<Producto> insert(Producto bean) {

        ArrayList<Producto> productos = null;

        try {
            this.motorMySQL.connect();

            String sql = SQL_INSERTAR_PRODUCTO + "('"
                    + bean.getNombre() + "', '"
                    + bean.getImagen() + "', '"
                    + bean.getDescripcion() + "', '"
                    + bean.getPrecio() + "', '"
                    + bean.getVendido() + "', '"
                    + bean.getPuntuacion() + "', '"
                    + bean.getCategoria() + "', '"
                    + bean.getUsuario().getIdUsuario() + "');";

            this.motorMySQL.execute(sql);

            this.motorMySQL.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
  
    }
    
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = new Producto();
        producto.setIdProducto(1);
        ArrayList<Producto> lstProductos = productoDAO.find1(producto);
        Producto.fromArrayListToJson(lstProductos);
        System.out.println(lstProductos.toString());
    }
    
}
