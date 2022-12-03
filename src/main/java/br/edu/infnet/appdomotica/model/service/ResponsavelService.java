package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.domain.Responsavel;
import br.edu.infnet.appdomotica.model.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	public void incluir(Responsavel responsavel) {
		responsavelRepository.save(responsavel);
		
		AppImpressao.relatorio("Criação do responsável '" + responsavel.getLogin() + "'", responsavel); 
	}
	
	public Collection<Responsavel> obterLista() {	
		return (Collection<Responsavel>) responsavelRepository.findAll();
	}
	
	public Collection<Responsavel> obterLista(Morador morador) {
		return responsavelRepository.obterLista(morador.getId());
	}
	
	public void excluir(Integer id) {
		responsavelRepository.deleteById(id);
	}
}
