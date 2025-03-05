package com.microservice.usertest.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@AllArgsConstructor
public class UserValidator implements Validator {

    private static final List<String> CREATE_REQUIRE_FIELD = List.of("name", "picture", "email");

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
