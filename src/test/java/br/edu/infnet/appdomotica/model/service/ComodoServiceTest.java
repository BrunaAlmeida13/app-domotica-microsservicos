package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.*;
import br.edu.infnet.appdomotica.model.exceptions.ComodoSemAparelhosException;
import br.edu.infnet.appdomotica.model.exceptions.ResponsavelNuloException;
import br.edu.infnet.appdomotica.model.repository.ComodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ComodoServiceTest {

    @Autowired
    private ComodoService comodoService;

    @Autowired
    private ComodoRepository comodoRepository;

    @Test
    public void saveDeveriaSalvarUmComodo() {
        Morador morador = new Morador();
        morador.setId(1);

      /*  Set<Aparelho> listaAparelhos = new HashSet<Aparelho>();
        Luz luz = new Luz();
        luz.setId(1);
        Fechadura fechadura = new Fechadura();
        fechadura.setId(1);
        listaAparelhos.add(luz);
        listaAparelhos.add(fechadura);*/

        Responsavel responsavel = new Responsavel();
        responsavel.setId(1);

        Comodo comodo = new Comodo();
        comodo.setTipo("Cômodo2");
        comodo.setNome("Segundo Cômodo Teste");
        comodo.setMorador(morador);
        comodo.setResponsavel(responsavel);

        comodoService.incluir(comodo);

        Comodo comodoEncontrado = (Comodo) comodoRepository.findAllById(Collections.singleton(comodo.getId()));

        assertEquals(comodo.getNome(), comodoEncontrado.getNome());
    }
}