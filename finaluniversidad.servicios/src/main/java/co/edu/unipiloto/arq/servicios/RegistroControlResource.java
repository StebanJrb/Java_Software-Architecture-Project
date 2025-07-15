/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arq.servicios;

import co.edu.unipiloto.arq.entity.RegistroControl;
import co.edu.unipiloto.arq.logica.ejb.RegistroControlFacadeLocal;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;

@Path("/registros")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroControlResource {

    @EJB
    private RegistroControlFacadeLocal registroFacade;

    @GET
    public List<RegistroControl> listarRegistros() {
        return registroFacade.findAll();
    }

    @GET
    @Path("{id}")
    public Response obtenerRegistro(@PathParam("id") Long id) {
        RegistroControl registro = registroFacade.find(id);
        if (registro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(registro).build();
    }

    @POST
    public Response crearRegistro(RegistroControl registro, @Context UriInfo uriInfo) {
        registroFacade.create(registro);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(registro.getId().toString());
        return Response.created(builder.build()).entity(registro).build();
    }

    @PUT
    @Path("{id}")
    public Response actualizarRegistro(@PathParam("id") Long id, RegistroControl nuevoRegistro) {
        RegistroControl existente = registroFacade.find(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setUsuario(nuevoRegistro.getUsuario());
        existente.setRol(nuevoRegistro.getRol());

        registroFacade.edit(existente);
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminarRegistro(@PathParam("id") Long id) {
        RegistroControl registro = registroFacade.find(id);
        if (registro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        registroFacade.remove(registro);
        return Response.noContent().build();
    }
}