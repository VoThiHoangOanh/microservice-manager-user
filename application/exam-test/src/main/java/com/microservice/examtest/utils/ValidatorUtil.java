package com.microservice.examtest.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.List;

public class ValidatorUtil {
    public static void requireNotEmptyByListField(Errors errors, List<String> fields) {
        fields.forEach(
                field -> ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "")
        );
    }

}
