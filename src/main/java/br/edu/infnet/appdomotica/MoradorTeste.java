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
import br.edu.infnet.appdomotica.model.service.MoradorService;

@Component
@Order(1)
public class MoradorTeste implements ApplicationRunner {

	@Autowired
	private MoradorService moradorService;
	
	private Morador morador;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		morador = new Morador();
		morador.setNome("Admin");
		morador.setEmail("admin@email.com");
		morador.setSenha("admin123");
		
		moradorService.incluir(morador);
		
		String dir = "C:\\Users\\bruna\\OneDrive\\Área de Trabalho\\EclipeEE_Workspace\\appdomotica\\src\\main\\webapp\\WEB-INF\\arquivos_txt\\";
		String arq = "morador.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha != null) {
					
					String[] campos = linha.split(";");
					
					morador = new Morador();
					morador.setNome(campos[0]);
					morador.setEmail(campos[1]);
					morador.setSenha(campos[2]);
					
					moradorService.incluir(morador);
					
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
