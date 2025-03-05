package com.microservice.sharedmodel.exception.bad_request;


import com.microservice.sharedmodel.exception.GeneralException;

public class BadRequestException extends GeneralException {

  public BadRequestException(String errorCode) {
    super(errorCode);
    this.setHttpStatus(400);
  }
}
