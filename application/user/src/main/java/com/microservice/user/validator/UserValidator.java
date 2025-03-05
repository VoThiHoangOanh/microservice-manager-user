package com.microservice.user.validator;

import com.microservice.user.dto.response.UserPayloadDTO;
import com.microservice.user.utils.ValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@AllArgsConstructor
public class UserValidator implements Validator {

    private static final List<String> CREATE_REQUIRE_FIELD = List.of("name", "email");

    @Override
    public boolean supports(Class<?> clazz) {
        return UserPayloadDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof UserPayloadDTO) {
            this.validCreateOrUpdated(errors, (UserPayloadDTO) target);
        }
    }

    private void validCreateOrUpdated(Errors errors, UserPayloadDTO requestDto) {
        // require filed
        ValidatorUtil.requireNotEmptyByListField(errors, CREATE_REQUIRE_FIELD);
    }
}
