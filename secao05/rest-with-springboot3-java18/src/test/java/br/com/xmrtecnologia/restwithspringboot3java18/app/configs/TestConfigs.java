package br.com.xmrtecnologia.restwithspringboot3java18.app.configs;

public class TestConfigs {

    // Porta padrão que o RestAssured vai utilizar para se conectar com o container para executar os testes
	public static final int SERVER_PORT = 8888;
	
    public static final String HEADER_PARAM_AUTHORIZATION = "Authorization";
    public static final String HEADER_PARAM_ORIGIN = "Origin";
    
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_XML = "application/xml";
    public static final String CONTENT_TYPE_YML = "application/x-yaml";

    public static final String ORIGIN_ERUDIO = "https://erudio.com.br";
    public static final String ORIGIN_SEMERU = "https://semeru.com.br";

}
