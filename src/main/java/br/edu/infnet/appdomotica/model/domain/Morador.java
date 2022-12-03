package br.edu.infnet.appdomotica.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.appdomotica.interfaces.IPrinter;

@Entity
@Table(name = "TMorador")
public class Morador implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String email;
	private String senha;

	@OneToMany
	@JoinColumn(name = "idMorador")
	private List<Responsavel> responsaveis;

	@OneToMany
	@JoinColumn(name = "idMorador")
	private List<Aparelho> aparelhos;

	@OneToMany
	@JoinColumn(name = "idMorador")
	private List<Comodo> comodos;

	public Morador() {
	}

	@Override
	public void impressao() {
		System.out.println("#Morador");
		System.out.println(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public List<Aparelho> getAparelhos() {
		return aparelhos;
	}

	public void setAparelhos(List<Aparelho> aparelhos) {
		this.aparelhos = aparelhos;
	}

	public List<Comodo> getComodos() {
		return comodos;
	}

	public void setComodos(List<Comodo> comodos) {
		this.comodos = comodos;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + "; E-mail: " + this.email + "; Senha: " + this.senha;
	}
}
