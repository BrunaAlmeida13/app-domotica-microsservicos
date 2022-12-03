package br.edu.infnet.appdomotica.model.domain.app;

import java.util.List;

import br.edu.infnet.appdomotica.interfaces.IPrinter;

public class Classe implements IPrinter {

	private String nome;
	private List<Atributo> atributos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	@Override
	public void impressao() {
		System.out.println("##" + nome);
		for(Atributo a : atributos) {
			a.impressao();
		}
	}

}
