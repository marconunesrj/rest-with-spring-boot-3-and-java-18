package br.com.xmrtecnologia.restwithspringboot3java18.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;
import br.com.xmrtecnologia.restwithspringboot3java18.app.converters.NumberConverter;
import br.com.xmrtecnologia.restwithspringboot3java18.app.exceptions.UnsupportedMathOperationException;
import br.com.xmrtecnologia.restwithspringboot3java18.app.utils.SimpleMath;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
@RestController
public class MathController {
    
    private SimpleMath math = new SimpleMath();
    
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception{
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception{
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception{
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @GetMapping(value = "/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable(value = "number") String number
            ) throws Exception{
        
        if(!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.squareRoot(NumberConverter.convertToDouble(number));
    }
}