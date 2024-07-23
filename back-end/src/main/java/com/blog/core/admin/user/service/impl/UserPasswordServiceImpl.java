package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.PasswordUpdateRequest;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.entity.User;
import com.blog.entity.UserPassword;
import com.blog.infrastructure.exception.ResourceNotFoundException;
import com.blog.repository.UserPasswordRepository;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPasswordServiceImpl implements UserPasswordService {

    private final UserPasswordRepository userPasswordRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void createUserPassword(PasswordCreationRequest passwordRequest) {

        User user = userRepository.findById(passwordRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + passwordRequest.getUserId()));

        String hashedPassword = passwordEncoder.encode(passwordRequest.getRawPassword());

        UserPassword userPassword = UserPassword.builder()
                .user(user)
                .password(hashedPassword)
                .build();

        userPasswordRepository.save(userPassword);
    }

    @Override
    public void updateUserPassword(PasswordUpdateRequest updateRequest) {

    }

}

