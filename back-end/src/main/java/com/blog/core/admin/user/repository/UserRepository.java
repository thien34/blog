package com.blog.core.admin.user.repository;

import com.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    Page<User> findByUsernameContaining(String username, Pageable pageable);

    Optional<User> findByUsername(String username);
}
