package com.microservice.usertest.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.List;

public class ValidatorUtil {


    public static void requireNotEmptyByListField(Errors errors, List<String> fields) {
        fields.forEach(
                field -> ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "")
        );
    }

//    public static void customReject(String errorMessage) throws BusinessLogicException {
//        throw BusinessLogicException
//                .builder()
//                .errorMessage(ErrorMessage.DATA_UN_VALID)
//                .params(List.of(errorMessage))
//                .build();
//    }
//
//    public static void customRejectMessage(Errors errors, BusinessLogicException ex) {
//        errors.reject(ex.getErrorMessage().getCode(),
//                ex.getErrorMessage().getMessageFm().formatted(ex.getParams()));
//    }
}
