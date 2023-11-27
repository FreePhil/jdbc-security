package com.example.jdbcsecurity.config;

import com.example.jdbcsecurity.model.SystemPermission;
import com.example.jdbcsecurity.repository.SystemPermissionRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SystemPermissionEvaluator {

    SystemPermissionRepository permissionRepository;

    public SystemPermissionEvaluator(SystemPermissionRepository repo) {
        this.permissionRepository = repo;
    }

    public boolean hasPermission(String permissionTag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            var userDetails = (UserDetails) authentication.getPrincipal();
            var username = userDetails.getUsername();
            var permissions = permissionRepository.findByUsernameAAndPermissionTag(username, permissionTag);


            if (permissions.size() == 1) {
                var permission = permissions.stream().findFirst();
                return permission.orElseThrow().getHasPermission();
            }
        }
        return true;
    }
}
