package com.example.jdbcsecurity.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationFetcher {

    public String getUsername() {
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        return authentication.map(a -> a.getName()).orElseThrow();
    }
}
