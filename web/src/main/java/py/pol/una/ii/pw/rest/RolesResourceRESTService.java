package py.pol.una.ii.pw.rest;

import py.pol.una.ii.pw.data.RolesRepository;
import py.pol.una.ii.pw.model.Member;
import py.pol.una.ii.pw.model.Roles;
import py.pol.una.ii.pw.service.RolesRegistration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.management.relation.Role;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Usuario on 02/08/2017.
 */
@Path("/roles")
@RequestScoped
public class RolesResourceRESTService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private RolesRepository repository;

    @Inject
    RolesRegistration registration;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> listAllRoles() {
        return repository.findAllOrderedByDescripcion();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Roles lookupRolById(@PathParam("id") long id) {
        Roles rol = repository.findRolById(id);
        if (rol == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return rol;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Roles roles) {
        Response.ResponseBuilder builder = null;
        try {
            registration.register(roles);
            builder = Response.ok();
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRol(@PathParam("id") Long id ,Roles rol) {

        Response.ResponseBuilder builder = null;

        try {

            registration.update(id, rol);

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
    public Response deletRol(@PathParam("id") Long id) {
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

}
