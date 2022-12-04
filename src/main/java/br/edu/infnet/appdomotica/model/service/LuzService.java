package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.Luz;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.LuzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LuzService {

    @Autowired
    private LuzRepository luzRepository;

    public void incluir(Luz luz) {
        luz.status();
        luzRepository.save(luz);
    }

    public Collection<Luz> obterLista() {
        return luzRepository.findAll();
    }

    public Collection<Luz> obterLista(Morador morador) {
        return luzRepository.findAll(morador.getId());
    }

    public void excluir(Integer id) {
        luzRepository.deleteById(id);
    }
}
