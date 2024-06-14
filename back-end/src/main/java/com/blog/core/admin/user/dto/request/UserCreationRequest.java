package com.blog.core.admin.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class UserCreationRequest {
    @Size(min = 5, message = "Username must be least 5 characters")
    private String username;

    @Email
    private String email;

    private String firstName;

    private String lastName;

    private Boolean gender;

    private Instant dateOfBirth;

    private String streetAddress;

    private String city;

    private String county;

    private String phone;

    @Size(min = 8, message = "Password must be least 8 characters")
    private String password;

}
