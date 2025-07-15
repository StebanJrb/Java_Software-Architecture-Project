/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arq.servicios;

import co.edu.unipiloto.arq.entity.Docente;
import co.edu.unipiloto.arq.logica.ejb.DocenteFacadeLocal;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;

@Path("/docentes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocenteResource {

    @EJB
    private DocenteFacadeLocal docenteFacade;

    @GET
    public List<Docente> obtenerTodos() {
        return docenteFacade.findAll();
    }

    @GET
    @Path("{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {
        Docente docente = docenteFacade.find(id);
        if (docente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(docente).build();
    }

    @POST
    public Response crear(Docente docente, @Context UriInfo uriInfo) {
        docenteFacade.create(docente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(docente.getId().toString());
        return Response.created(builder.build()).entity(docente).build();
    }

    @PUT
    @Path("{id}")
    public Response actualizar(@PathParam("id") Long id, Docente nuevoDocente) {
        Docente existente = docenteFacade.find(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNombre(nuevoDocente.getNombre());
        existente.setCorreo(nuevoDocente.getCorreo());

        docenteFacade.edit(existente);
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminar(@PathParam("id") Long id) {
        Docente docente = docenteFacade.find(id);
        if (docente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        docenteFacade.remove(docente);
        return Response.noContent().build();
    }
}