package uce.edu.web.api.matricula.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.domain.Materia;
import uce.edu.web.api.matricula.infrastructure.MateriaRepository;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public List<Materia> listarTodos() {
        return this.materiaRepository.findAll().list();
    }

    public Materia listarTodosId(Integer id) {
        return this.materiaRepository.findById(id.longValue());
    }

    @Transactional
    public void guardarMateria(Materia materia) {
        this.materiaRepository.persist(materia);
    }

    @Transactional
    public void actualizarMateria(Integer id, Materia materia) {
        Materia mate = this.listarTodosId(id);
        mate.setNombre(materia.getNombre());
        mate.setCodigo(materia.getCodigo());
        mate.setCreditos(materia.getCreditos());
    }

    @Transactional
    public void actualizarParcialMateria(Integer id, Materia materia) {
        Materia mate = this.listarTodosId(id);
        if (materia.getNombre() != null) {
            mate.setNombre(materia.getNombre());
        }
        if (materia.getCodigo() != null) {
            mate.setCodigo(materia.getCodigo());
        }
        if (materia.getCreditos() != null) {
            mate.setCreditos(materia.getCreditos());
        }
    }

    @Transactional
    public void eliminarMateria(Integer id) {
        this.materiaRepository.deleteById(id.longValue());
    }

    @Transactional
    public Materia buscarPorCodigo(String codigo) {
        return this.materiaRepository.buscarPorCodigo(codigo);
    }

    @Transactional
    public Materia listarCreditos(Integer creditos) {
        return this.materiaRepository.listarCreditoMayor(creditos);
    }
}
