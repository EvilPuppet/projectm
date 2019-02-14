package projeto.moveis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String nome;
	public String cpf;
	public String telefone;
	public String cep;
	
	@ManyToOne
	public List<Projeto> projeto;
	
	public List<Projeto> getProjeto() {
		return projeto;
	}
	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}