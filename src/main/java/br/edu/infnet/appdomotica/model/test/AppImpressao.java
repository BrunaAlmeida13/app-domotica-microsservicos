package br.edu.infnet.appdomotica.model.test;

import br.edu.infnet.appdomotica.interfaces.IPrinter;

public class AppImpressao {

	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);

		printer.impressao();
	}

}
