package com.example.jdbcsecurity.controller;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String name() {
        return "Hello, World";
    }

    @PreAuthorize("admin")
    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin";
    }
}
