package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.AppImpressao;
import br.edu.infnet.appdomotica.model.domain.ArCondicionado;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.ArCondicionadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArCondicionadoService {

    @Autowired
    private ArCondicionadoRepository arCondicionadoRepository;

    public void incluir(ArCondicionado ac) {
        ac.status();
        arCondicionadoRepository.save(ac);
    }

    public Collection<ArCondicionado> obterLista() {
        return arCondicionadoRepository.findAll();
    }

    public Collection<ArCondicionado> obterLista(Morador morador) {
        return arCondicionadoRepository.findAll(morador.getId());
    }

    public void excluir(Integer id) {
        arCondicionadoRepository.deleteById(id);
    }
}
