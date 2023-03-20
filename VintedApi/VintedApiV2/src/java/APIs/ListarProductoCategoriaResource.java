/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package APIs;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.producto.Producto;
import model.producto.ProductoDAO;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

/**
 * REST Web Service
 *
 * @author maria
 */
@Path("listarProductoCategoria")
public class ListarProductoCategoriaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ListarProductoCategoriaResource
     */
    public ListarProductoCategoriaResource() {
    }

    /**
     * Retrieves representation of an instance of APIs.ListarProductoCategoriaResource
     * @param categoria
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listarProductoCategoria/{categoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("categoria")String categoria) {
        if (categoria.equals("Todos")){
            categoria = null;
        }

        Producto producto = new Producto();
        producto.setCategoria(categoria);
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> lstProductos = productoDAO.findCategoria(producto);
        return Producto.fromArrayListToJson(lstProductos);
    }
    
    @GET
    @Path("listarProductoCategoria/{categoria}/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("categoria")String categoria, @PathParam("nombre")String nombre) {
        if (categoria.equals("Todos")){
            categoria = null;
        }
        if (nombre.equals("Nombre") ){
            nombre = null;
        }

        Producto producto = new Producto();
        producto.setCategoria(categoria);
        producto.setNombre(nombre);
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> lstProductos = productoDAO.findCategoria(producto);
        return Producto.fromArrayListToJson(lstProductos);
    }

    /**
     * PUT method for updating or creating an instance of ListarProductoCategoriaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
