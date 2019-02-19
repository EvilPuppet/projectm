package projeto.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.moveis.model.Projeto;

@Repository
public interface ProjectRespository extends CrudRepository<Projeto, Long> {

}
