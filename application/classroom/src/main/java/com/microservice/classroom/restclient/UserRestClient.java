package com.microservice.classroom.restclient;

import com.microservice.sharedmodel.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${rest-client.user.url}")
public interface UserRestClient {
    @GetMapping(value = "/api/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUserById(@PathVariable String id);
}