package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.PasswordUpdateRequest;
import com.blog.core.admin.user.repository.UserPasswordRepository;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.entity.UserPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPasswordServiceImpl implements UserPasswordService {

    private final UserPasswordRepository userPasswordRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUserPassword(PasswordCreationRequest passwordRequest) {
        UserPassword userPassword = UserPassword.builder()
                .user(passwordRequest.getUser())
                .password(passwordEncoder.encode(passwordRequest.getRawPassword()))
                .build();
        userPasswordRepository.save(userPassword);
    }

    @Override
    public void updateUserPassword(PasswordUpdateRequest updateRequest) {

    }

}

