package application.testSuites;

import application.testCases.api.ApiTest;
import application.testCases.web.SicrediSavingsInvestmentSimulatorTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import project.framework.Reports;

@RunWith(Suite.class)
@SuiteClasses({
        SicrediSavingsInvestmentSimulatorTest.class,
        ApiTest.class
})

public class SuiteTestRegressionTest {
    @BeforeClass
    public static void initTest() {
        Reports.create("Execução de testes WEB e API do site Simulador de Investimento Poupança Sicredi", "Regressão de Testes");
    }
    @AfterClass
    public static void endTest() {
        Reports.close();
    }

}
