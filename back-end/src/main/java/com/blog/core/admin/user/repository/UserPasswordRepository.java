package com.blog.core.admin.user.repository;

import com.blog.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPasswordRepository extends JpaRepository<UserPassword, Long>{
}
