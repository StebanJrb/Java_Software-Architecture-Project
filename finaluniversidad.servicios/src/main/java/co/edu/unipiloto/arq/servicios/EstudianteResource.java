/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arq.servicios;

import co.edu.unipiloto.arq.entity.Estudiante;
import co.edu.unipiloto.arq.logica.ejb.EstudianteFacadeLocal;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;

@Path("/estudiantes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteResource {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

    @GET
    public List<Estudiante> listarEstudiantes() {
        return estudianteFacade.findAll();
    }

    @GET
    @Path("{id}")
    public Response obtenerEstudiante(@PathParam("id") Long id) {
        Estudiante estudiante = estudianteFacade.find(id);
        if (estudiante == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(estudiante).build();
    }

    @POST
    public Response crearEstudiante(Estudiante estudiante, @Context UriInfo uriInfo) {
        estudianteFacade.create(estudiante);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(estudiante.getId().toString());
        return Response.created(builder.build()).entity(estudiante).build();
    }

    @PUT
    @Path("{id}")
    public Response actualizarEstudiante(@PathParam("id") Long id, Estudiante nuevoEstudiante) {
        Estudiante existente = estudianteFacade.find(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNombre(nuevoEstudiante.getNombre());
        existente.setCorreo(nuevoEstudiante.getCorreo());

        estudianteFacade.edit(existente);
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminarEstudiante(@PathParam("id") Long id) {
        Estudiante estudiante = estudianteFacade.find(id);
        if (estudiante == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        estudianteFacade.remove(estudiante);
        return Response.noContent().build();
    }
}