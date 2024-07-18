package com.blog.core.admin.user.dto.request;

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
public class UserUpdateRequest {

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

}
