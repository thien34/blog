package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.PasswordUpdateRequest;
import com.blog.core.admin.user.repository.UserPasswordRepository;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.entity.UserPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    private final UserPasswordRepository userPasswordRepository;
//    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public UserPasswordServiceImpl(UserPasswordRepository userPasswordRepository, PasswordEncoder passwordEncoder) {
//        this.userPasswordRepository = userPasswordRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Autowired
    public UserPasswordServiceImpl(UserPasswordRepository userPasswordRepository) {
        this.userPasswordRepository = userPasswordRepository;
    }

    @Override
    public void createUserPassword(PasswordCreationRequest passwordRequest) {
        UserPassword userPassword = UserPassword.builder()
                .user(passwordRequest.getUser())
//                .password(passwordEncoder.encode(passwordRequest.getRawPassword()))
                .password(passwordRequest.getRawPassword())
                .passwordFormatId(1)
                .build();
        userPasswordRepository.save(userPassword);
    }

    @Override
    public void updateUserPassword(PasswordUpdateRequest updateRequest) {

    }

}

