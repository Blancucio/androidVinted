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
import javax.ws.rs.core.MediaType;
import model.producto.Producto;
import model.producto.ProductoDAO;

/**
 * REST Web Service
 *
 * @author S2-PC00
 */
@Path("find1")
public class Find1Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Find1Resource
     */
    public Find1Resource() {
    }

    /**
     * Retrieves representation of an instance of APIs.Find1Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Producto producto = new Producto();
        producto.setIdProducto(1);
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> lstProductos = productoDAO.find1(producto);
        return Producto.fromArrayListToJson(lstProductos);
    }

    /**
     * PUT method for updating or creating an instance of Find1Resource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
