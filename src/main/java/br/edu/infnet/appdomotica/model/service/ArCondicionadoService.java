package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.ArCondicionado;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.ArCondicionadoRepository;

@Service
public class ArCondicionadoService {
	
	@Autowired
	private ArCondicionadoRepository arCondicionadoRepository;
	
	public void incluir(ArCondicionado ac) {
		ac.status();
		arCondicionadoRepository.save(ac);
		
		AppImpressao.relatorio("Configuração do A.C.'" + ac.getNome() + "'", ac); 
	}
	
	public Collection<ArCondicionado> obterLista() {
		return (Collection<ArCondicionado>) arCondicionadoRepository.findAll();
	}
	
	public Collection<ArCondicionado> obterLista(Morador morador) {
		return (Collection<ArCondicionado>) arCondicionadoRepository.findAll(morador.getId());
	}
	
	public void excluir(Integer id) {
		arCondicionadoRepository.deleteById(id);
	}	
}
