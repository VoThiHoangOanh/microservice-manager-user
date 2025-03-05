package com.microservice.usertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


public abstract class ValidatorController<T extends Validator> {

    @Autowired
    private T validator;


    @InitBinder
    public void handler(WebDataBinder binder) {
        binder.addValidators(validator);
    }
}
