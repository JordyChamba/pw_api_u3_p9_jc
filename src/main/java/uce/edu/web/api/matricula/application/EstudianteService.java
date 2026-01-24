package uce.edu.web.api.matricula.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.application.representation.EstudianteRepresentation;
import uce.edu.web.api.matricula.domain.Estudiante;
import uce.edu.web.api.matricula.infrastructure.EstudianteRepository;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public List<EstudianteRepresentation> listarTodos() {
        return this.estudianteRepository.findAll().list().stream()
                .map(this::mapperToER)
                .toList();
    }

    public EstudianteRepresentation consultarPorId(Integer id) {
        return this.mapperToER(this.estudianteRepository.findById(id.longValue()));
    }

    private Estudiante consultarPorIdInterno(Integer id) {
        return this.estudianteRepository.findById(id.longValue());
    }

    @Transactional
    public void crearEstudiante(Estudiante estudiante) {
        this.estudianteRepository.persist(estudiante);
    }

    @Transactional
    public void actualizarEstudiante(Integer id, Estudiante estudiante) {
        Estudiante estudianteActual = this.consultarPorIdInterno(id);
        estudianteActual.setNombre(estudiante.getNombre());
        estudianteActual.setApellido(estudiante.getApellido());
        estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
        // se actualiza por dirty checking
    }

    @Transactional
    public void actualizacionParcial(Integer id, Estudiante estudiante) {
        Estudiante estudianteActual = this.consultarPorIdInterno(id);
        if (estudiante.getNombre() != null) {
            estudianteActual.setNombre(estudiante.getNombre());
        }
        if (estudiante.getApellido() != null) {
            estudianteActual.setApellido(estudiante.getApellido());
        }
        if (estudiante.getFechaNacimiento() != null) {
            estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
        }
    }

    @Transactional
    public void eliminarEstudiante(Integer id) {
        this.estudianteRepository.deleteById(id.longValue());
    }

    public List<EstudianteRepresentation> listarPorProvincia(String provincia, String genero) {
        return this.estudianteRepository.find("provincia = ?1 and genero = ?2", provincia, genero).list().stream()
                .map(this::mapperToER).toList();
    }

    private EstudianteRepresentation mapperToER(Estudiante estudiante) {
        EstudianteRepresentation estudianteRepresentation = new EstudianteRepresentation();
        estudianteRepresentation.setId(estudiante.getId());
        estudianteRepresentation.setNombre(estudiante.getNombre());
        estudianteRepresentation.setApellido(estudiante.getApellido());
        estudianteRepresentation.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteRepresentation.setProvincia(estudiante.getProvincia());
        estudianteRepresentation.setGenero(estudiante.getGenero());
        return estudianteRepresentation;
    }

    private Estudiante mapperToEstudiante(EstudianteRepresentation estudiante) {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setId(estudiante.getId());
        estudiante1.setNombre(estudiante.getNombre());
        estudiante1.setApellido(estudiante.getApellido());
        estudiante1.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudiante1.setProvincia(estudiante.getProvincia());
        estudiante1.setGenero(estudiante.getGenero());
        return estudiante1;
    }
}
