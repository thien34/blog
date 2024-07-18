package com.blog.repository;

import com.blog.entity.UserUserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleMappingRepository extends JpaRepository<UserUserRoleMapping, Long> {
}