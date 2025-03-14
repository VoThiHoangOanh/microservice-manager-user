package com.microservice.sharedmodel.exception.not_found;


import com.microservice.sharedmodel.exception.GeneralException;

public class ResourceNotFoundException extends GeneralException {

    public ResourceNotFoundException(Class<?> resourceClass, Object entityId) {
        super("RESOURCE_NOT_FOUND");
        this.args = new String[]{resourceClass.getSimpleName(), entityId.toString()};
        this.setHttpStatus(404);
    }
}
