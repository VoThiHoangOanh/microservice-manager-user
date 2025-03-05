package com.microservice.sharedmodel.exception.external_error;

import com.microservice.sharedmodel.exception.GeneralException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ExternalException extends GeneralException {
  protected Exception rootCause;
  protected String msg;

  public ExternalException(String errorCode) {
    super(errorCode);
  }

  @Override
  public String getMessage() {
    return String.format("%s due to [%s]", super.getMessage(), this.getMsg());
  }
}
