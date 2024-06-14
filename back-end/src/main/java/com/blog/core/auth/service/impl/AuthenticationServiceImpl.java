package com.blog.core.auth.service.impl;

import com.blog.core.admin.user.repository.UserPasswordRepository;
import com.blog.core.admin.user.repository.UserRepository;
import com.blog.core.auth.dto.request.AuthenticationRequest;
import com.blog.core.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserPasswordRepository userPasswordRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean authenticate(AuthenticationRequest authenticationRequest) {

        var user = userRepository.findByUsername(authenticationRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var pass = userPasswordRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Password not found"));

        return passwordEncoder.matches(authenticationRequest.getPassword(), pass.getPassword());
    }
}
