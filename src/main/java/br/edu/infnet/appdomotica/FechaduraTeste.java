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

import br.edu.infnet.appdomotica.model.domain.Fechadura;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.exceptions.TamanhoMaximoSenhaException;
import br.edu.infnet.appdomotica.model.service.FechaduraService;

@Component
@Order(4)
public class FechaduraTeste implements ApplicationRunner {

	@Autowired
	private FechaduraService fechaduraService;

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

					if ("F".equalsIgnoreCase(campos[0])) {
						try {
							Fechadura fechadura = new Fechadura();
							fechadura.setNome(campos[1]);
							fechadura.setStatus(campos[2]);
							fechadura.timerInicioConversao(campos[3]);
							fechadura.timerFimConversao(campos[4]);
							fechadura.setSenha(campos[5]);
							fechadura.setTrancada(Boolean.valueOf(campos[6]));
							fechadura.setAlarme(Boolean.valueOf(campos[7]));
							fechadura.setMorador(morador);
							System.out.println("Duração agendada do tempo de funcionamento: "
									+ fechadura.quantidadeHorasAgendada());
							fechaduraService.incluir(fechadura);
						} catch (TamanhoMaximoSenhaException e) {
							System.out.println("[ERROR - FECHADURA] " + e.getMessage() + "\n");
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
