package com.example.jdbcsecurity.controller;

import com.example.jdbcsecurity.service.AuthenticationFetcher;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private AuthenticationFetcher authFetcher;

    public HomeController(AuthenticationFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @GetMapping("/")
    public String name() {
        logger.debug("{} enters /", authFetcher.getUsername());
        return "Hello, World";
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @GetMapping("/signout")
    public ModelAndView logout() {
        logger.debug("{} enters /signout", authFetcher.getUsername());
        return new ModelAndView("redirect:/logout");
    }

    @PreAuthorize("hasRole('ROLE_admin') and @systemPermissionEvaluator.hasPermission('home_admin')")
    @GetMapping("/admin")
    public String admin() {
        logger.info("{} enter /admin", authFetcher.getUsername());
        return "Hello, Admin";
    }

    @PreAuthorize("hasRole('ROLE_admin') or @systemPermissionEvaluator.hasPermission('home_misc')")
    @GetMapping("/misc")
    public String misc() {
        logger.info("{} enter /misc", authFetcher.getUsername());
        return "Hello, Misc";
    }
}
