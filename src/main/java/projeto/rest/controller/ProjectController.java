package projeto.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.api.rest.repository.ProjectRespository;
import projeto.moveis.model.Projeto;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

	@Autowired
	private ProjectRespository projectRespository;
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Projeto> searchProject(@PathVariable(value="id") Long id) {
		Optional<Projeto> project = projectRespository.findById(id);
		return new ResponseEntity<Projeto>(project.get(), HttpStatus.OK);
	}
	
	@GetMapping(value="/", produces="application/json")
	public ResponseEntity<List<Projeto>> searchProjectId() {
		List<Projeto> projects = (List<Projeto>) projectRespository.findAll();
		return new ResponseEntity<List<Projeto>>(projects, HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces="application/json")
	public ResponseEntity<Projeto> register(@RequestBody Projeto projeto) {
		Projeto projectSalve = projectRespository.save(projeto);
		return new ResponseEntity<Projeto>(projectSalve, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Void> deleteClients(@PathVariable("id") Long id) {
		projectRespository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/", produces="application/json")
	public ResponseEntity<Projeto> change(@RequestBody Projeto projeto) {
		Projeto projectSalve = projectRespository.save(projeto);
		return new ResponseEntity<Projeto>(projectSalve, HttpStatus.OK);
	}
	
}
