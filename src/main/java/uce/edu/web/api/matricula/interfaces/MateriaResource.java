package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.matricula.application.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/materias")
/*
 * @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
 * 
 * @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
 */

public class MateriaResource {
    @Inject
    private MateriaService materiaService;

    /*
     * @GET
     * 
     * @Path("")
     * public List<Materia> consultarTodos() {
     * return this.materiaService.listarTodos();
     * }
     */

    @GET
    @Path("")
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Materia> consultarTodos() {
        return this.materiaService.listarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_XML)
    public Materia consultarTodosId(@PathParam("id") Integer id) {
        return this.materiaService.listarTodosId(id);
    }

    @POST
    @Path("")
    public Response guardarMateria(Materia materia) {
        this.materiaService.guardarMateria(materia);
        return Response.status(Response.Status.CREATED).entity(materia).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizarMateria(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizarMateria(id, materia);
        return Response.status(209).entity(null).build();
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcialMateria(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizarParcialMateria(id, materia);
    }

    @DELETE
    @Path("/{id}")
    public void eliminarMateria(@PathParam("id") Integer id) {
        this.materiaService.eliminarMateria(id);
    }

    // ---------------------------
    @GET
    @Path("/codigo/{codigo}")
    public Materia buscarPorCodigo(@PathParam("codigo") String codigo) {
        return materiaService.buscarPorCodigo(codigo);
    }

    @GET
    @Path("/creditos/{creditos}")
    public Materia buscarPorCodigo(@PathParam("creditos") Integer creditos) {
        return this.materiaService.listarCreditos(creditos);
    }
}
