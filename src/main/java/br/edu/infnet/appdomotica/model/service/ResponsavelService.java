package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.domain.Responsavel;
import br.edu.infnet.appdomotica.model.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public void incluir(Responsavel responsavel) {
        responsavelRepository.save(responsavel);

    }

    public Collection<Responsavel> obterLista() {
        return responsavelRepository.findAll();
    }

    public Collection<Responsavel> obterLista(Morador morador) {
        return responsavelRepository.obterLista(morador.getId());
    }

    public void excluir(Integer id) {
        responsavelRepository.deleteById(id);
    }
}
