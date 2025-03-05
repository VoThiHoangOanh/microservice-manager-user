//package com.microservice.restclient.config;
//
//
//import feign.Logger;
//import lombok.NoArgsConstructor;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@EnableFeignClients(basePackages = "com.microservice**")
//@NoArgsConstructor
//public class RestClientConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.BASIC;
//    }
//
//}
