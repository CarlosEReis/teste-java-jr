package com.carloser7.teste.domain.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

public class Validador {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void validar(Object obj) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
