package com.example.jdbcsecurity.config;

import com.example.jdbcsecurity.model.SystemPermission;
import com.example.jdbcsecurity.repository.SystemPermissionRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

@Component
public class SystemPermissionEvaluator {

    SystemPermissionRepository permissionRepository;

    public SystemPermissionEvaluator(SystemPermissionRepository repo) {
        this.permissionRepository = repo;
    }

    public boolean hasPermission(String permissionTag) {
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        return authentication.map(auth -> {
            var permission = permissionRepository.findOneByUsernameAAndPermissionTag(auth.getName(), permissionTag);
            return permission.map(p -> p.getHasPermission()).orElse(false);
        }).orElse(false);

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            var username = authentication.getName();
//            var permission = permissionRepository.findOneByUsernameAAndPermissionTag(username, permissionTag);
//            if (permission.isPresent()) {
//                return permission.get().getHasPermission();
//            }
//        }
//        return false;
    }
}
