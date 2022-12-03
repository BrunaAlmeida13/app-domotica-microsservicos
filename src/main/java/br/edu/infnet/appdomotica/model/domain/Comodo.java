package br.edu.infnet.appdomotica.model.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.appdomotica.interfaces.IPrinter;
import br.edu.infnet.appdomotica.model.exceptions.ComodoSemAparelhosException;
import br.edu.infnet.appdomotica.model.exceptions.ResponsavelNuloException;

@Entity
@Table(name = "TComodo")
public class Comodo implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;
	private String nome;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private Set<Aparelho> listaAparelhos;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idResponsavel")
	private Responsavel responsavel;

	@ManyToOne
	@JoinColumn(name = "idMorador")
	private Morador morador;

	public Comodo() {
	}

	public Comodo(Responsavel responsavel, Set<Aparelho> listaAparelhos)
			throws ResponsavelNuloException, ComodoSemAparelhosException {

		if (responsavel == null) {
			throw new ResponsavelNuloException("Não tem como controlar os aparelhos de um cômodo sem um responsável.");
		}

		/*
		 * if (listaAparelhos == null) { throw new
		 * ComodoSemAparelhosException("Não tem como controlar um cômodo sem uma listagem de aparelhos."
		 * ); }
		 * 
		 * if (listaAparelhos.size() < 1) { throw new
		 * ComodoSemAparelhosException("Não tem como controlar um cômodo sem aparelhos."
		 * ); }
		 */

		this.responsavel = responsavel;
		this.listaAparelhos = listaAparelhos;
	}

	@Override
	public void impressao() {
		System.out.println("#Fechadura");
		System.out.println(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Aparelho> getListaAparelhos() {
		return listaAparelhos;
	}

	public void setListaAparelhos(Set<Aparelho> listaAparelhos) {
		this.listaAparelhos = listaAparelhos;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	@Override
	public String toString() {
		return "Tipo: " + this.tipo + "; Nome: " + this.nome + "; \nResponsavel: " + responsavel
				+ "; \nNúmero de aparelhos no cômodo: " + listaAparelhos.size() + "\n";
		// listaAparelhos.toString()
	}
}
