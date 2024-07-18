package com.blog.core.admin.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 5, message = "Username must be least 5 characters")
    String username;

    @Email
    String email;

    String firstName;

    String lastName;

    Boolean gender;

    Instant dateOfBirth;

    String streetAddress;

    String city;

    String county;

    String phone;

    @Size(min = 8, message = "Password must be least 8 characters")
    String password;

}
