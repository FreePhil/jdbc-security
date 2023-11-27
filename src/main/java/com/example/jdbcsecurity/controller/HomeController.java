package com.example.jdbcsecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String name() {
        return "Hello, World";
    }

    @PreAuthorize("hasRole('ROLE_admin') and @systemPermissionEvaluator.hasPermission('home_admin')")
//    @Secured("ROLE_admin")
    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin";
    }
}
