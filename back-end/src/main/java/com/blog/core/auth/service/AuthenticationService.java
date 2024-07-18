package com.blog.core.auth.service;

import com.blog.core.auth.dto.request.AuthenticationRequest;
import com.blog.core.auth.dto.request.IntrospectRequest;
import com.blog.core.auth.dto.response.AuthenticationResponse;
import com.blog.core.auth.dto.response.IntrospectResponse;
import com.blog.entity.User;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    String generateToken(User user);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
