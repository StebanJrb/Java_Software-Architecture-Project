/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arq.servicios;

import co.edu.unipiloto.arq.entity.RegistroNotas;
import co.edu.unipiloto.arq.logica.ejb.RegistroNotasFacadeLocal;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;

@Path("/notas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroNotasResource {

    @EJB
    private RegistroNotasFacadeLocal registroNotasFacade;

    @GET
    public List<RegistroNotas> listarNotas() {
        return registroNotasFacade.findAll();
    }

    @GET
    @Path("{id}")
    public Response obtenerNota(@PathParam("id") Long id) {
        RegistroNotas nota = registroNotasFacade.find(id);
        if (nota == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(nota).build();
    }

    @POST
    public Response crearNota(RegistroNotas registro, @Context UriInfo uriInfo) {
        registroNotasFacade.create(registro);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(registro.getId().toString());
        return Response.created(builder.build()).entity(registro).build();
    }

    @PUT
    @Path("{id}")
    public Response actualizarNota(@PathParam("id") Long id, RegistroNotas nuevaNota) {
        RegistroNotas existente = registroNotasFacade.find(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNota(nuevaNota.getNota());
        existente.setEstudiante(nuevaNota.getEstudiante());
        existente.setSeccion(nuevaNota.getSeccion());

        registroNotasFacade.edit(existente);
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminarNota(@PathParam("id") Long id) {
        RegistroNotas registro = registroNotasFacade.find(id);
        if (registro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        registroNotasFacade.remove(registro);
        return Response.noContent().build();
    }
}
