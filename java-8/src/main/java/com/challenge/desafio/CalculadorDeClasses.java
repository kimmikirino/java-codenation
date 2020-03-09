package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    private BigDecimal calcula(Object classe, Class anotacao) throws IllegalAccessException {
        Field[] campos = classe.getClass().getDeclaredFields();
        BigDecimal qtd = BigDecimal.ZERO;
        for (Field campo : campos) {
            if(campo.isAnnotationPresent(anotacao) && campo.getType().equals(BigDecimal.class)) {
                campo.setAccessible(true);
                qtd = qtd.add((BigDecimal) campo.get(classe));
            }
        }
        return qtd;
    }

    @Override
    public BigDecimal somar(Object classe) throws IllegalAccessException {
        return this.calcula(classe, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException {
        return this.calcula(objeto, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException {
        return somar(objeto).subtract(subtrair(objeto));
    }

}
