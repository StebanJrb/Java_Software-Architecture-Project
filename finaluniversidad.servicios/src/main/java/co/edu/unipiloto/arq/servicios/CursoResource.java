/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arq.servicios;

import co.edu.unipiloto.arq.entity.Curso;
import co.edu.unipiloto.arq.logica.ejb.CursoFacadeLocal;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;

@Path("/cursos")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    @EJB
    private CursoFacadeLocal cursoFacade;

    @GET
    public List<Curso> obtenerCursos() {
        return cursoFacade.findAll();
    }

    @GET
    @Path("{id}")
    public Response obtenerCurso(@PathParam("id") Long id) {
        Curso curso = cursoFacade.find(id);
        if (curso == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(curso).build();
    }

    @POST
    public Response crearCurso(Curso curso, @Context UriInfo uriInfo) {
        cursoFacade.create(curso);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(curso.getId().toString());
        return Response.created(builder.build()).entity(curso).build();
    }

    @PUT
    @Path("{id}")
    public Response actualizarCurso(@PathParam("id") Long id, Curso cursoActualizado) {
        Curso existente = cursoFacade.find(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNombre(cursoActualizado.getNombre());
        existente.setDescripcion(cursoActualizado.getDescripcion());

        cursoFacade.edit(existente);
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminarCurso(@PathParam("id") Long id) {
        Curso curso = cursoFacade.find(id);
        if (curso == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cursoFacade.remove(curso);
        return Response.noContent().build();
    }
}
