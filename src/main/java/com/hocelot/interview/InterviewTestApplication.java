package com.hocelot.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InterviewTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterviewTestApplication.class, args);
    }
}