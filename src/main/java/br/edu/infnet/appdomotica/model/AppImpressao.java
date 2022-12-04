package br.edu.infnet.appdomotica.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {

    public static void main(String[] args) {
        String dir = "C:\\Users\\bruna\\OneDrive\\Área de Trabalho\\EclipeEE_Workspace\\appdomotica\\src\\main\\webapp\\WEB-INF\\arquivos_txt\\";
        String arq = "comodos.txt";

        try {
            try {
                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha = leitura.readLine();
                while (linha != null) {
                    System.out.println(linha);
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
