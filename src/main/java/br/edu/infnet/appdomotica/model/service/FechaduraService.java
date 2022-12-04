package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.Fechadura;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.FechaduraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FechaduraService {

    @Autowired
    private FechaduraRepository fechaduraRepository;

    public void incluir(Fechadura fechadura) {
        fechadura.status();
        fechaduraRepository.save(fechadura);
    }

    public Collection<Fechadura> obterLista() {
        return fechaduraRepository.findAll();
    }

    public Collection<Fechadura> obterLista(Morador morador) {
        return fechaduraRepository.findAll(morador.getId());
    }

    public void excluir(Integer id) {
        fechaduraRepository.deleteById(id);
    }
}
