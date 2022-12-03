package br.edu.infnet.appdomotica.model.exceptions;

public class TemperaturaNaoPodeSerMuitoBaixa extends Exception {

	private static final long serialVersionUID = 1L;

	public TemperaturaNaoPodeSerMuitoBaixa(String mensagem) {
		super(mensagem);
	}
}
