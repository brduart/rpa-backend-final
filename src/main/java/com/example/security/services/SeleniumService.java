package com.example.security.services;

import com.example.security.dto.selenium.SeleniumResponseDto;
import com.example.security.entities.Status;
import com.example.security.selenium.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class SeleniumService {

    public SeleniumResponseDto performLogin() {
        WebDriverManager.chromedriver().setup();

        // Configuração do Chrome
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");  // Rodar sem abrir a interface gráfica (opcional)

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://soulmv.green-sempapel.com.br/");

//             Criando a instância do Page Object
            LoginPage loginPage = new LoginPage(driver);
//
            // Interação com a página
            loginPage.enterUsername("dbamv");
            loginPage.enterPassword("Green@2023@1");
            loginPage.selectOption();
            loginPage.clickLogin();

            // Retornando o título da página após login
            return new SeleniumResponseDto("Teste OK!!", Status.FINALIZADO);
        } catch (Exception e) {
            return new SeleniumResponseDto("Erro ao executar o Selenium", Status.ERRO);
        } finally {
           driver.quit();
        }
}

    public SeleniumResponseDto performButton() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://soulmv.green-sempapel.com.br/");

            // Criando a instância do Page Object
//            LoginPage loginPage = new LoginPage(driver);

            // Interação com a página
//            loginPage.enterUsername(username);
//            loginPage.enterPassword(password);
//            loginPage.clickLogin();

            // Retornando o título da página após login
            return new SeleniumResponseDto("Teste OK!!", Status.FINALIZADO);
        } catch (Exception e) {
            return new SeleniumResponseDto("Erro ao executar o Selenium", Status.ERRO);
        } finally {
            driver.quit();
        }
    }

//    public SeleniumResponseDto performerRegister() {
//    }

//    public SeleniumResponseDto performInput() {
//    }


    }


