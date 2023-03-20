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
import javax.ws.rs.core.MediaType;
import model.producto.Producto;
import model.producto.ProductoDAO;

/**
 * REST Web Service
 *
 * @author maria
 */
@Path("Llistar10ProductosValoracion")
public class Llistar10ProductosValoracionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Llistar10ProductosValoracionResource
     */
    public Llistar10ProductosValoracionResource() {
    }

    /**
     * Retrieves representation of an instance of APIs.Llistar10ProductosValoracionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> lstProductos = productoDAO.mayorPuntuacion(null);
        return Producto.fromArrayListToJson(lstProductos);
    }

    /**
     * PUT method for updating or creating an instance of Llistar10ProductosValoracionResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
