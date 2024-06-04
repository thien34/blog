package com.blog.core.admin.user.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class UserCreationRequest {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Boolean gender;

    private Instant dateOfBirth;

    private String streetAddress;

    private String city;

    private String county;

    private String phone;

    private String password;

}
