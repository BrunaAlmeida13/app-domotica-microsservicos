package br.edu.infnet.appdomotica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appdomotica.model.domain.Aparelho;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.AparelhoRepository;

@Service
public class AparelhoService {
	
	@Autowired
	private AparelhoRepository aparelhoRepository;
	
	public Collection<Aparelho> obterLista() {
		return (Collection<Aparelho>) aparelhoRepository.findAll();
	}
	
	public Collection<Aparelho> obterLista(Morador morador) {
		return (Collection<Aparelho>) aparelhoRepository.findAll(morador.getId());
	}
	
	public void excluir(Integer id) {
		aparelhoRepository.deleteById(id);
	}
}
