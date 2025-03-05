package com.microservice.examtest.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ExamTestValidator implements Validator {
    private static final List<String> CREATE_REQUIRE_FIELD = List.of("examtest");

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
