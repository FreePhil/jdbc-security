package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.SystemPermission;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface SystemPermissionRepository extends CrudRepository<SystemPermission, Long> {

    /**
     *
     */
    @Query("select * from system_permissions where username = :username and permission_tag = :permissionTag limit 1")
    Optional<SystemPermission> findOneByUsernameAAndPermissionTag(String username, String permissionTag);
}
