//package com.microservice.restclient.client;
//
//import com.microservice.restclient.config.RestClientConfiguration;
//import com.microservice.sharedmodel.user.dto.UserDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.Optional;
//
//@FeignClient(
//        name = "user",
//        url = "localhost:8081",
//        configuration = RestClientConfiguration.class)
//public interface CommonUserRestClient {
//
//    @GetMapping("/external/public/api/user/{userId}")
//    Optional<UserDTO> getUserById(@PathVariable("userId") String userId);
//}
