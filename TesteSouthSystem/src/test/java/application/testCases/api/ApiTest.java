package application.testCases.api;


import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.aventstack.extentreports.Status;
import project.framework.Reports;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class ApiTest {
    private String baseUri;

    @Before
    public void setUp() {
        Reports.startTest("Teste - API do Simulador de Investimento.");
        baseUri = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";
        Reports.log(Status.INFO, "A API foi carregada");
    }

    @Test
    public void testCheckstatusCode200() {
        given()
                .when()
                .get(baseUri)
                .then()
                .statusCode(200);
        Reports.log(Status.PASS, "A api está retornado o Status Code 200 conforme esperado");
    }

    @Test
    public void testCheckId() {
        given()
                .when()
                .get(baseUri)
                .then()
                .statusCode(200)
                .body("id", Matchers.is(1));
        Reports.log(Status.PASS, "A api está retornado o Id correto");

    }

    @Test
    public void testCheckListOfMonths() {
        given()
                .when()
                .get(baseUri)
                .then()
                .statusCode(200)
                .body(containsString("\"meses\":[\"112\",\"124\",\"136\",\"148\"]"));
        Reports.log(Status.PASS, "A api está retornado o a lista de Meses correta");
    }

    @Test
    public void testCheckListOfValues() {
        given()
                .when()
                .get(baseUri)
                .then()
                .statusCode(200)
                .body(containsString("\"valor\":[\"2.802\",\"3.174\",\"3.564\",\"3.971\"]"));
        Reports.log(Status.PASS, "A api está retornado o a lista de Valores correta");
    }

    @After
    public void tearDown() {
        Reports.close();
    }
}
