package br.com.xmrtecnologia.restwithspringboot3java18.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;
import br.com.xmrtecnologia.restwithspringboot3java18.app.model.Greeting;


@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";
    
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));        
    }

}
