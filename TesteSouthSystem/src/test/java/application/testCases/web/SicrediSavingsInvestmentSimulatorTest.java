package application.testCases.web;

import application.tasks.FormTask;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import project.framework.Drivers;
import project.framework.Reports;
import project.framework.ScreenShots;

public class SicrediSavingsInvestmentSimulatorTest {
    private WebDriver driver;
    private FormTask form;

    @Before
    public void setUp() {
        Reports.create("Resultado das Execuções de Testes", "DashBoards dos testes");
        driver = Drivers.getFirefoxDriver();
        form = new FormTask(driver);
    }

    @Test
    public void testFormValidDataTest() {
        Reports.startTest("Cenário 01 - Preenchimento do formulário com dados válidos e visualização do formulário de simulação..");
        driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        driver.manage().window().maximize();
        Reports.log(Status.INFO, "O Website do Sicredi foi carregado.", ScreenShots.capture(driver));
        form.selectProfile();
        form.enterValueToApply("20,00");
        form.enterValueToSave("20,00");
        form.howMuchDoYouWantToSaveEveryMonth("10");
        form.selectMonths();
        form.clickOnTheSimulateButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(form.getTextSimulationForm().equalsIgnoreCase("Veja estas outras opções para você")) {
            Reports.log(Status.PASS, "Validação - Formulário da Simulação está visível.", ScreenShots.capture(driver));
        } else {
            Reports.log(Status.FAIL, "Validação - Formulário da Simulação não está visível.", ScreenShots.capture(driver));
        }
        Assert.assertEquals("Veja estas outras opções para você", form.getTextSimulationForm());
    }

    @Test
    public void testFormInvalidDataTest() {
        Reports.startTest("Cenário 02 - O associado preencher o valor inferior a “R$ 20.00” e receber a mensagem de orientação “Valor mínimo de R$ 20.00”.");
        driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        driver.manage().window().maximize();
        form.selectProfile();
        form.enterValueToApply("19,99");
        form.enterValueToSave("19,99");
        form.howMuchDoYouWantToSaveEveryMonth("10");
        form.selectMonths();
        form.clickOnTheSimulateButton();
        if(form.getTextMsgMinValue().equalsIgnoreCase("Valor mínimo de R$ 20.00")) {
            Reports.log(Status.PASS, "Validação - Da mensagem de orientação “Valor mínimo de R$ 20.00”.", ScreenShots.capture(driver));
        } else {
            Reports.log(Status.FAIL, "Validação - O sistema não está apresentando a mensagem de orientação “Valor mínimo de R$ 20.00”. ", ScreenShots.capture(driver));
        }
        Assert.assertEquals("Valor mínimo de R$ 20.00", form.getTextMsgMinValue());
    }

    @Test
    public void testCheckSimulatorPageTest() {
        Reports.startTest("Cenário 03 - Url: https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        driver.manage().window().maximize();
        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/")) {
            Reports.log(Status.PASS, "Validação - A página de Simulação de Investimentos Poupança do Sicredi foi carregada com sucesso.", ScreenShots.capture(driver));
        } else {
            Reports.log(Status.FAIL, "Validação - A página de Simulação de Investimentos Poupança do Sicredi não está sendo carregada.", ScreenShots.capture(driver));
        }
        Assert.assertEquals("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        Reports.close();
        driver.quit();
    }

}


