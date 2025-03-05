package com.microservice.classroom.handler;

import com.microservice.common.response.BaseResponseError;
import com.microservice.sharedmodel.enums.ErrorMessage;
import com.microservice.classroom.exception.BusinessLogicException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CusExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<BaseResponseError<BaseResponseError.Error>> responses = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            responses.add(BaseResponseError.builder().status(HttpStatus.BAD_REQUEST.value())
                    .data(BaseResponseError.Error.builder()
                            .code(ErrorMessage.DATA_UN_VALID.getCode())
                            .message(ErrorMessage.DATA_UN_VALID.getMessageFm().formatted(error.getDefaultMessage()))
                            .build()).build());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CollectionUtils.isEmpty(responses) ? null : responses.get(0));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<Object> handleBusinessLogicException(BusinessLogicException ex) {
        ErrorMessage errorMessage = ex.getErrorMessage();
        BaseResponseError.Error error = BaseResponseError.Error.builder()
                .code(errorMessage.getCode())
                .message(errorMessage.getMessageFm().formatted(ex.getParams()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
