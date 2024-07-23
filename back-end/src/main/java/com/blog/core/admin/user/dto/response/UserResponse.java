package com.blog.core.admin.user.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String username;

    String email;

    String firstName;

    String lastName;

    Boolean gender;

    Instant dateOfBirth;

    String streetAddress;

    String city;

    String county;

    String phone;

    Boolean active;

    Boolean deleted;

    LocalDateTime createdDate;

    Set<String> userRole;

}
