package com.blog.core.auth.service;

import com.blog.core.auth.dto.request.AuthenticationRequest;

public interface AuthenticationService {

    Boolean authenticate(AuthenticationRequest authenticationRequest);

}
