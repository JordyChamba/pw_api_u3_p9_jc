package uce.edu.web.api.matricula.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.matricula.domain.Materia;

@ApplicationScoped
public class MateriaRepository implements PanacheRepository<Materia> {

    public Materia buscarPorCodigo(String codigo) {
        return find("codigo = ?1", codigo).firstResult();
    }

    public Materia listarCreditoMayor(Integer creditos) {
        return find("creditos = ?1", creditos).firstResult();
    }

}
