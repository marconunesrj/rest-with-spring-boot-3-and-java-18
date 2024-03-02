package br.com.xmrtecnologia.restwithspringboot3java18.app.utils;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne +  numberTwo;
    }
    
    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne -  numberTwo;
    }
    
    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }
    
    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne +  numberTwo) / 2;
    }
    
    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
