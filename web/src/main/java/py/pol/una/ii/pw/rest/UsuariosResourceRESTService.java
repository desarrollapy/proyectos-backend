package py.pol.una.ii.pw.rest;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
// import py.pol.una.ii.pw.authentication.PermissionManager;
import py.pol.una.ii.pw.data.UsuariosRepository;
import py.pol.una.ii.pw.model.Permisos;
import py.pol.una.ii.pw.model.Usuario;
import py.pol.una.ii.pw.service.UsuariosRegistration;
// import py.pol.una.ii.pw.util.Claim;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Usuario on 02/08/2017.
 */
@Path("/usuarios")
@RequestScoped
public class UsuariosResourceRESTService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private UsuariosRepository repository;

    @Inject
    UsuariosRegistration registration;

    // @Inject
    // PermissionManager permissionManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listAllRoles() {
        return repository.findAllOrderedByName();
    }

    /* @GET
    @Path("/permisos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Permisos> listUserPerm(@Context HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        StringTokenizer st = new StringTokenizer(authHeader);
        String basic = st.nextToken();
        String credentials = st.nextToken();
        StringTokenizer tokens=new StringTokenizer(credentials, ".");
        String j64 = tokens.nextToken();
        String c64 = tokens.nextToken();
        Claim claim = toClaim(fromBase64(c64));
        return permissionManager.listPerm(claim.username, claim.ID);
    }*/

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario lookupUsuarioById(@PathParam("id") long id) {
        Usuario user = repository.findUsuarioById(id);
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Usuario usuario) {
        Response.ResponseBuilder builder = null;
        try {
            System.out.println(usuario.getPassword());
            registration.register(usuario);

            // Create an "ok" response
            builder = Response.ok();
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteUsuario(@PathParam("id") Long id) {
        Response.ResponseBuilder builder = null;

        try{
            registration.delete(id);
            builder = Response.ok();
        }catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return builder.build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateHuesped(@PathParam("id") Long id ,Usuario huesped) {

        Response.ResponseBuilder builder = null;

        try {

            registration.update(id, huesped);

            // Create an "ok" response
            builder = Response.ok();
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }

    /*private Claim toClaim(String json){
        Gson g = new Gson();
        return g.fromJson(json, Claim.class);
    }*/
    private String fromBase64(String str){
        byte[] valueDecoded= Base64.decodeBase64(str.getBytes());
        return new String(valueDecoded);
    }
}
