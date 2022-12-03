package br.edu.infnet.appdomotica.model.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.app.Projeto;

@Service
public class AppService {

	private Projeto projeto;
	
	public void incluir(Projeto projeto) {
		this.projeto = projeto;
		
		AppImpressao.relatorio("Exibição do projeto" + projeto.getNome() + " realizada com sucesso!", projeto);
	}
	
	public Projeto obterProjeto() {
		return projeto;
	}
}
