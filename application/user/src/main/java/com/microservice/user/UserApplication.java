package com.microservice.user;

import com.microservice.sharedmodel.mongojpa.EnableMongoJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoJpa
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.microservice.user.*",
        "com.microservice.sharedmodel.*"
//        ,"com.microservice.restclient.*"
})
@EnableMongoRepositories(basePackages = {
        "com.microservice.user.repository"
})
@EnableFeignClients(basePackages = {"com.microservice.*"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
