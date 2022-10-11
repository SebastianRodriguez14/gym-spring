package com.tecfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GymSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymSpringApplication.class, args);
    }

}