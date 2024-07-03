package com.blog.core.auth.controller;

import com.blog.core.auth.dto.request.AuthenticationRequest;
import com.blog.core.auth.dto.request.IntrospectRequest;
import com.blog.core.auth.service.AuthenticationService;
import com.blog.core.common.ResponseData;
import com.blog.core.common.ResponseError;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ResponseData<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            var result = authenticationService.authenticate(request);
            return new ResponseData<>(HttpStatus.OK.value(), "Authenticated successfully", result);
        } catch (Exception e) {
            log.error("Error authenticating", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @PostMapping("/introspect")
    public ResponseData<?> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        try {
            var result = authenticationService.introspect(request);
            return new ResponseData<>(HttpStatus.OK.value(), "Introspected successfully", result);
        } catch (Exception e) {
            log.error("Error introspecting", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }

    }
}
