package com.blog.repository;

import com.blog.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Page<Permission> findByNameContaining(String username, Pageable pageable);

}