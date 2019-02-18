package projeto.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.api.rest.repository.ClientsRepository;
import projeto.moveis.model.Clients;

@RestController
@RequestMapping(value="/clients")
public class ClientsController {

	@Autowired
	private ClientsRepository clientsRepository;
	
	@GetMapping(value = "/{id}", produces="application/json")
	public ResponseEntity<Clients> searchClients(@PathVariable (value="id") Long id) {
		Optional<Clients>  clients = clientsRepository.findById(id);
		
		return new ResponseEntity<Clients>(clients.get(), HttpStatus.OK);
	}
	
	@GetMapping(value="/", produces="application/json")
	public ResponseEntity<List<Clients>> searchAllClients() {
		List<Clients> clients = (List<Clients>) clientsRepository.findAll();
		return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces="application/json")
	public ResponseEntity<Clients> register(@RequestBody Clients clients) {
		Clients clientsSalve = clientsRepository.save(clients);
		
		return new ResponseEntity<Clients>(clientsSalve, HttpStatus.OK);
	}
}
