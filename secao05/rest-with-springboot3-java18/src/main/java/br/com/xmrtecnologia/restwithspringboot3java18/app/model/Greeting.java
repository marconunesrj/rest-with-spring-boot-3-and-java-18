package br.com.xmrtecnologia.restwithspringboot3java18.app.model;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
public class Greeting {

    private final Long id;
    private final String content;
    
    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
      
}
