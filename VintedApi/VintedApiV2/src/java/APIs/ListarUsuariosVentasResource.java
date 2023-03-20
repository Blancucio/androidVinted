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
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

/**
 * REST Web Service
 *
 * @author maria
 */
@Path("listarUsuariosVentas")
public class ListarUsuariosVentasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ListarUsuariosVentasResource
     */
    public ListarUsuariosVentasResource() {
    }

    /**
     * Retrieves representation of an instance of APIs.ListarUsuariosVentasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> lstUsuarios = usuarioDAO.usuarioMayorVentas(null);
        return Usuario.fromArrayListToJson(lstUsuarios);
    }

    /**
     * PUT method for updating or creating an instance of ListarUsuariosVentasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
