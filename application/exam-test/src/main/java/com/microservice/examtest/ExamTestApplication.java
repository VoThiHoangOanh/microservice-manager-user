package com.microservice.examtest;

import com.microservice.sharedmodel.mongojpa.EnableMongoJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoJpa
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.microservice.examtest.*",
        "com.microservice.sharedmodel.*"})
@EnableMongoRepositories(basePackages = {
        "com.microservice.examtest.repository"
})
@EnableFeignClients(basePackages = {"com.microservice.*"})
public class ExamTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamTestApplication.class, args);
    }

}
