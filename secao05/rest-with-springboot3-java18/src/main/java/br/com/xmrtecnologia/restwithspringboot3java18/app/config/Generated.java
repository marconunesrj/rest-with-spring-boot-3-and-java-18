package br.com.xmrtecnologia.restwithspringboot3java18.app.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// https://www.baeldung.com/jacoco-report-exclude
//Utilizada para não fazer parte dos testes coverage jacoco
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Generated {
}