package br.edu.infnet.appdomotica.model.exceptions;

public class VolumeSomInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public VolumeSomInvalidoException(String mensagem) {
		super(mensagem);
	}
}
