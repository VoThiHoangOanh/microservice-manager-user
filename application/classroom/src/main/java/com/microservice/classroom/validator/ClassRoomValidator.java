package com.microservice.classroom.validator;

import com.microservice.classroom.dto.response.CreateClassRoomResponseDTO;
import com.microservice.classroom.utils.ValidatorUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ClassRoomValidator implements Validator {
    private static final List<String> CREATE_REQUIRE_FIELD = List.of("classname");


    @Override
    public boolean supports(Class<?> clazz) {
        return CreateClassRoomResponseDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof CreateClassRoomResponseDTO) {
            this.validCreateOrUpdated(errors, (CreateClassRoomResponseDTO) target);
        }
    }
    private void validCreateOrUpdated(Errors errors, CreateClassRoomResponseDTO response) {
        ValidatorUtil.requireNotEmptyByListField(errors, CREATE_REQUIRE_FIELD);
    }
}
