/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIs;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.producto.Producto;
import model.producto.ProductoDAO;
import model.usuario.Usuario;

/**
 * REST Web Service
 *
 * @author congd
 */
@Path("lstProductosUsuario")
public class LstProductosUsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LstProductosUsuarioResource
     */
    public LstProductosUsuarioResource() {
    }
    @GET
    @Path("lstProductosUsuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id")int id) {
        Producto producto = new Producto();
        producto.getUsuario().setIdUsuario(id);
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> lstProductos = productoDAO.productosVenta(producto);
        return Producto.fromArrayListToJson(lstProductos);
    }
    /**
     * Retrieves representation of an instance of APIs.LstProductosUsuarioResource
     * @return an instance of java.lang.String
     */


    /**
     * PUT method for updating or creating an instance of LstProductosUsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
