package com.example.jdbcsecurity.model;

import org.springframework.data.annotation.Id;

public class SystemPermission {

    @Id Long id;
    String username;
    String permissionTag;
    boolean hasPermission;

    public boolean getHasPermission() { return hasPermission; }
}
