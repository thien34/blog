package com.blog.core.admin.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;

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

    private Boolean active;

    private Boolean deleted;

    private LocalDateTime createdDate;

}
