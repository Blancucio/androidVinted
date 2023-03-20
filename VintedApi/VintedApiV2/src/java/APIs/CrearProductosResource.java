/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 * REST Web Service
 *
 * @author congd
 */
@Path("crearProductos")
public class CrearProductosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CrearProductosResource
     */
    public CrearProductosResource() {
    }
    
    @GET
    @Path("crearProductos/{nombre}/{categoria}/{descripcion}/{precio}/{puntuacion}/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("nombre")String nombre, @PathParam("categoria")String categoria, @PathParam("descripcion")String descripcion, @PathParam("precio")String precio, @PathParam("puntuacion")String puntuacion, @PathParam("usuario")String usuario) {
        Producto producto = new Producto();
        ProductoDAO productoDAO = new ProductoDAO();
        producto.setNombre(nombre);
        producto.setCategoria(categoria);
        producto.setDescripcion(descripcion);
        producto.setPrecio(Integer.valueOf(precio));
        producto.setVendido("0");
        producto.setPuntuacion(Integer.valueOf(puntuacion));
        producto.getUsuario().setIdUsuario(Integer.valueOf(usuario));
      
        ArrayList<Producto> lstProductos = productoDAO.insert(producto);
        return "Blancash";
    }

    /**
     * PUT method for updating or creating an instance of CrearProductosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
