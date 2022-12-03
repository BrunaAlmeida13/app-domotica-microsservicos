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

import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.domain.Responsavel;
import br.edu.infnet.appdomotica.model.exceptions.CpfInvalidoException;
import br.edu.infnet.appdomotica.model.service.ResponsavelService;

@Component
@Order(2)
public class ResponsavelTeste implements ApplicationRunner {

	@Autowired
	private ResponsavelService responsavelService;
	
	@Override
	public void run(ApplicationArguments args) {

		Morador morador = new Morador();
		morador.setId(1);
		
		String dir = "C:\\Users\\bruna\\OneDrive\\Área de Trabalho\\EclipeEE_Workspace\\appdomotica\\src\\main\\webapp\\WEB-INF\\arquivos_txt\\";
		String arq = "responsavel.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {
					
					String[] campos = linha.split(";");
					
					try {
						Responsavel responsavel = new Responsavel(campos[0], campos[1], campos[2], campos[3]);
						
						responsavel.setMorador(morador);
						
						responsavelService.incluir(responsavel);
					} catch (CpfInvalidoException e) {
						System.out.println("[ERROR - RESPONSAVEL] " + e.getMessage() + "\n");
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
