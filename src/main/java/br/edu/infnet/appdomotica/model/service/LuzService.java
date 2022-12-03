package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.Luz;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.LuzRepository;

@Service
public class LuzService {

	@Autowired
	private LuzRepository luzRepository;

	public void incluir(Luz luz) {
		luz.status();
		luzRepository.save(luz);

		AppImpressao.relatorio("Configuração Luz '" + luz.getNome() + "'", luz);
	}

	public Collection<Luz> obterLista() {
		return (Collection<Luz>) luzRepository.findAll();
	}
	
	public Collection<Luz> obterLista(Morador morador) {
		return (Collection<Luz>) luzRepository.findAll(morador.getId());
	}

	public void excluir(Integer id) {
		luzRepository.deleteById(id);
	}
}
