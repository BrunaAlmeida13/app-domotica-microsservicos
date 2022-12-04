package br.edu.infnet.appdomotica.model.service;

import br.edu.infnet.appdomotica.model.domain.Comodo;
import br.edu.infnet.appdomotica.model.domain.Luz;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.repository.LuzRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LuzServiceTest {

    @Autowired
    private LuzService luzService;

    @Autowired
    private LuzRepository luzRepository;

    @Test
    public void saveDeveriaSalvarLuz() {
        Morador morador = new Morador();
        morador.setId(1);

        Comodo comodo = new Comodo();
        comodo.setId(1);

        Luz luz = new Luz();
        luz.setNome("Luz quarto Ian");
        luz.setStatus("On");
        luz.timerInicioConversao("2022-12-25T08:30");
        luz.timerFimConversao("2022-12-25T19:30");
        luz.setCor("azul");
        luz.setIntensidade(2);
        luz.setVolumeSom(50);
        luz.setPower(true);
        luz.setMorador(morador);
        luz.setComodo(comodo);

        luzService.incluir(luz);

        assertTrue(luzRepository.existsById(luz.getId()));
    }
}
