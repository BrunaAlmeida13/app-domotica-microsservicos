package br.edu.infnet.appdomotica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appdomotica.model.domain.Luz;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.exceptions.VolumeSomInvalidoException;
import br.edu.infnet.appdomotica.model.service.LuzService;

@Component
@Order(3)
public class LuzTeste implements ApplicationRunner {

	@Autowired
	private LuzService luzService;

	@Override
	public void run(ApplicationArguments args) {
		
		Morador morador = new Morador();
		morador.setId(1);
		
		String dir = "C:\\Users\\bruna\\OneDrive\\Área de Trabalho\\EclipeEE_Workspace\\appdomotica\\src\\main\\webapp\\WEB-INF\\arquivos_txt\\";
		String arq = "aparelho.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {

					String[] campos = linha.split(";");

					if ("L".equalsIgnoreCase(campos[0])) {
						try {
							Luz luz = new Luz();
							luz.setNome(campos[1]);
							luz.setStatus(campos[2]);
							luz.timerInicioConversao(campos[3]);
							luz.timerFimConversao(campos[4]);
							luz.setCor(campos[5]);
							luz.setIntensidade(Integer.valueOf(campos[6]));
							luz.setVolumeSom(Integer.valueOf(campos[7]));
							luz.setPower(Boolean.valueOf(campos[8]));
							luz.setMorador(morador);
							luzService.incluir(luz);
							System.out.println(
									"Duração agendada do tempo de funcionamento: " + luz.quantidadeHorasAgendada());
					
						} catch (VolumeSomInvalidoException e) {
							System.out.println("[ERROR - LUZ] " + e.getMessage() + "\n");
						}
					}

					linha = leitura.readLine();
				}

				leitura.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe!");
			} catch (IOException e) {
				System.out.println("[ERRO] Problema no fechamento do arquivo!");
			}
		} finally {
			System.out.println("Finalizado.");
		}

	}
}
