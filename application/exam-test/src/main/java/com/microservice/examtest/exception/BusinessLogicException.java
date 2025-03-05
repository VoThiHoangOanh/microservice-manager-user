package com.microservice.examtest.exception;


import com.microservice.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class BusinessLogicException extends Exception{
    private ErrorMessage errorMessage;

    private List<String> params;
}
