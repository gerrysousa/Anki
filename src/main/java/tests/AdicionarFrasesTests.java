package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TudoPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static base.DriverFactory.getDriver;
import static utils.Constantes.pathProjeto;

public class AdicionarFrasesTests extends BaseTests {

    @Test
    public void Test_DataDrivenTestCadastrarTarefas() throws IOException, InterruptedException {
        new LoginPage().preencherEmail("email@gmail.com");
        new LoginPage().preencherSenha("senha");
        new LoginPage().clicarBotaoLogin();

        List<String[]> dadosCSV =  lerDadosCSV();

        new TudoPage().clicarBotaoAdd();

        int i=0;
        for (String[] registro : dadosCSV) {
            String front	    = registro[i];
            String back	    = registro[i+1];

            new TudoPage().escreverFrontCard(front);
            Thread.sleep(500);
            new TudoPage().escreverBackCard(back);
            Thread.sleep(500);
            new TudoPage().escreverTagCard("Automatico_Sem_audio");
            Thread.sleep(500);
            new TudoPage().clicarBotaoSalvar();
            Thread.sleep(1000);
        }

    }


    public List<String[]> lerDadosCSV() throws IOException {
        int count = 0;
        String file = pathProjeto+"/src/main/resources/AnkiFrases.csv";
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(";"));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return content;
    }

}
