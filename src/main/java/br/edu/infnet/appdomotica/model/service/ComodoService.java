package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.Comodo;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.ComodoRepository;

@Service
public class ComodoService {
	
	@Autowired
	private ComodoRepository comodoRepository;
	
	public void incluir(Comodo comodo) {
		
		comodoRepository.save(comodo);
		
		AppImpressao.relatorio("Configuração do comodo '" + comodo.getNome() + "'", comodo);
	}
	
	public Collection<Comodo> obterLista() {
		return (Collection<Comodo>) comodoRepository.findAll();
	}
	
	public Collection<Comodo> obterLista(Morador morador) {
		return (Collection<Comodo>) comodoRepository.findAll(morador.getId());
	}
	
	public void excluir(Integer id) {
		comodoRepository.deleteById(id);
	}
}
