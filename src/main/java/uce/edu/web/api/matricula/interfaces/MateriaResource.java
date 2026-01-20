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
import uce.edu.web.api.matricula.application.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/materias")
@Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
@Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
public class MateriaResource {
    @Inject
    private MateriaService materiaService;

    @GET
    @Path("/listarTodo")
    public List<Materia> consultarTodos() {
        return this.materiaService.listarTodos();
    }

    @GET
    @Path("/listarTodo/{id}")
    public Materia consultarTodosId(@PathParam("id") Integer id) {
        return this.materiaService.listarTodosId(id);
    }

    @POST
    @Path("/guardarMateria")
    public void guardarMateria(Materia materia) {
        this.materiaService.guardarMateria(materia);
    }

    @PUT
    @Path("/actualizarMateria/{id}")
    public void actualizarMateria(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizarMateria(id, materia);
    }

    @PATCH
    @Path("/actualizarParcialMateria/{id}")
    public void actualizarParcialMateria(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizarParcialMateria(id, materia);
    }

    @DELETE
    @Path("/eliminarMateria/{id}")
    public void eliminarMateria(@PathParam("id") Integer id) {
        this.materiaService.eliminarMateria(id);
    }

    // ---------------------------
    @GET
    @Path("/buscarCodigo/{codigo}")
    public Materia buscarPorCodigo(@PathParam("codigo") String codigo) {
        return materiaService.buscarPorCodigo(codigo);
    }

    @GET
    @Path("/listarCreditos/{creditos}")
    public Materia buscarPorCodigo(@PathParam("creditos") Integer creditos) {
        return this.materiaService.listarCreditos(creditos);
    }
}
