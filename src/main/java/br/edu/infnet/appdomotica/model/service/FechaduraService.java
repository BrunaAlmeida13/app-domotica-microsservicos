package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.Fechadura;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.FechaduraRepository;

@Service
public class FechaduraService {

	@Autowired
	private FechaduraRepository fechaduraRepository;

	public void incluir(Fechadura fechadura) {
		fechadura.status();
		fechaduraRepository.save(fechadura);

		AppImpressao.relatorio("Configuração da Fechadura '" + fechadura.getNome() + "'", fechadura);
	}

	public Collection<Fechadura> obterLista() {
		return (Collection<Fechadura>) fechaduraRepository.findAll();
	}

	public Collection<Fechadura> obterLista(Morador morador) {
		return (Collection<Fechadura>) fechaduraRepository.findAll(morador.getId());
	}

	public void excluir(Integer id) {
		fechaduraRepository.deleteById(id);
	}
}
