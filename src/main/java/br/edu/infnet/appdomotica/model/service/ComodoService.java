package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.Comodo;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.ComodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ComodoService {

    @Autowired
    private ComodoRepository comodoRepository;

    public void incluir(Comodo comodo) {

        comodoRepository.save(comodo);
    }

    public Collection<Comodo> obterLista() {
        return comodoRepository.findAll();
    }

    public Collection<Comodo> obterLista(Morador morador) {
        return comodoRepository.findAll(morador.getId());
    }

    public void excluir(Integer id) {
        comodoRepository.deleteById(id);
    }
}
