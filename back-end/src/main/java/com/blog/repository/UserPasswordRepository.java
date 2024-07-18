package com.blog.repository;

import com.blog.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPasswordRepository extends JpaRepository<UserPassword, Long> {

    Optional<UserPassword> findByUserId(Long userId);

}
