package com.microservice.classroom;

import com.microservice.sharedmodel.mongojpa.EnableMongoJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoJpa
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.microservice.classroom.*",
        "com.microservice.sharedmodel.*"})
@EnableMongoRepositories(basePackages = {
        "com.microservice.classroom.repository"
})
@EnableFeignClients(basePackages = {"com.microservice.*"})
public class ClassroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class, args);
    }

}
