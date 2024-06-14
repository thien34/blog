package com.blog.core.auth.controller;

import com.blog.core.auth.dto.request.AuthenticationRequest;
import com.blog.core.auth.dto.response.AuthenticationResponse;
import com.blog.core.auth.service.AuthenticationService;
import com.blog.core.common.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")

    public ResponseData<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        Boolean result = authenticationService.authenticate(request);
        return new ResponseData<>(HttpStatus.OK.value(),
                "Authenticated successfully",
                new AuthenticationResponse(result));
    }

}
