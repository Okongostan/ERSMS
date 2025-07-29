package com.erms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.erms.controller", "com.erms.model", "com.erms.repository"})
@EntityScan("com.erms.model")
@EnableJpaRepositories("com.erms.repository")
public class ErmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErmsApplication.class, args);
    }
}