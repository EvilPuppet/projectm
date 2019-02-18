package projeto.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.moveis.model.Clients;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, Long> {

	
}
