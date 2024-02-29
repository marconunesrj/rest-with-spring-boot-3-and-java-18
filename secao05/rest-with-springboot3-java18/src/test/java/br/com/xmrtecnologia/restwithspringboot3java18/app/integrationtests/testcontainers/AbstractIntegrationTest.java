package br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.testcontainers;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

// OBS: Para executar o teste eu tive que fazer o download da imagem: "testcontainers/ryuk:latest", e já colocá-la no Docker, depois 
//      atualizar a versão no pom.xml para "1.19.6", que era a mais recente quando executei o teste

// Para utilizar o Rest Assured no TestContainer
@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

//	    https://testcontainers.com/getting-started/?_gl=1*1vzysvn*_up*MQ..*_ga*MTc4MDA5MTE4OS4xNzA5MTcwNDIz*_ga_22TYV8FBPD*MTcwOTE3MDQyMC4xLjAuMTcwOTE3MDQyMC4wLjAuMA..
//	    GenericContainer container = new GenericContainer("postgres:15")
//	            .withExposedPorts(5432)
//	            .waitingFor(new LogMessageWaitStrategy()
//	                .withRegEx(".*database system is ready to accept connections.*\\s")
//	                .withTimes(2)
//	                .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS)));
//	    container.start();
//	    var username = "test";
//	    var password = "test";
//	    var jdbcUrl = "jdbc:postgresql://" + container.getHost() + ":" + container.getMappedPort(5432) + "/test";
//	    //perform db operations
//	    container.stop();
	    
//	    https://java.testcontainers.org/modules/databases/postgres/
//	    https://github.com/testcontainers/testcontainers-java/issues/1278
//	    PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:15");
//	    postgres.start();
//	    var username = postgres.getUsername();
//	    var password = postgres.getPassword();
//	    var jdbcUrl = postgres.getJdbcUrl();
//	    //perform db operations
//	    postgres.stop();
//	    
//	    // https://testcontainers.com/modules/postgresql/?_gl=1*utydhq*_up*MQ..*_ga*MTc4MDA5MTE4OS4xNzA5MTcwNDIz*_ga_22TYV8FBPD*MTcwOTE3MDQyMC4xLjEuMTcwOTE3MDQ3Mi4wLjAuMA..
//	    var postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"));
//	    postgres.start();

	    // A Imagem e versão do MySql deve ser vista no Dockerhub a última no momento deste curso era 8.3.0   https://hub.docker.com/_/mysql
		static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.29");
		
		private static void startContainers() {
			Startables.deepStart(Stream.of(mysql)).join();
		}

		private static Map<String, String> createConnectionConfiguration() {
		    
		    // Atribuindo os valores para as variáveis de ambiente do TestContainer a serem utilizadas pelo Spring
			return Map.of(
				"spring.datasource.url", mysql.getJdbcUrl(),
				"spring.datasource.username", mysql.getUsername(),
				"spring.datasource.password", mysql.getPassword()
			);
		}
		
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
		    
			startContainers();
			
			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			
			// Acessar o TestContainer e criar a conexão
			MapPropertySource testcontainers = new MapPropertySource(
				"testcontainers",
				(Map) createConnectionConfiguration());
			
			// Adicionando as variáveis de ambiente do Spring as informações do TestContainer
			environment.getPropertySources().addFirst(testcontainers);
		}
	}
}
