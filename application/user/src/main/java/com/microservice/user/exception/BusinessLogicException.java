package com.microservice.user.exception;

import com.microservice.sharedmodel.enums.ErrorMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BusinessLogicException extends Exception {

    private ErrorMessage errorMessage;

    private List<String> params;

}
