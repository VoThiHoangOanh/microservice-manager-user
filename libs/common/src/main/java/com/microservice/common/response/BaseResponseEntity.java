package com.microservice.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BaseResponseEntity<T> {

    private int status;

    private T data;
}
