package com.example.jdbcsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class JdbcSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcSecurityApplication.class, args);
    }

}
