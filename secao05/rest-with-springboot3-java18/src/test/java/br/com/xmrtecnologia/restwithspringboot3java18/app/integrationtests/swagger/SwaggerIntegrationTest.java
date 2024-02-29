package br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.xmrtecnologia.restwithspringboot3java18.app.configs.TestConfigs;
import br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.testcontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest{

	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content =
			given()
				.basePath("/swagger-ui/index.html")
				.port(TestConfigs.SERVER_PORT)
			.when()
				.get()
			.then()
				.statusCode(200)
//				.log().all()
				.extract()
					.body()
						.asString();
		assertTrue(content.contains("Swagger UI"));
	}

}
