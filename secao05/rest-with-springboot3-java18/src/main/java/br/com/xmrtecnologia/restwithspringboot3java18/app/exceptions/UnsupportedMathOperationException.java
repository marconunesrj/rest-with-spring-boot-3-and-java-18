package br.com.xmrtecnologia.restwithspringboot3java18.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

    public UnsupportedMathOperationException(String ex) {
        super(ex);
    }

    private static final long serialVersionUID = 1L;
}