package com.blog.core.admin.user.mapper;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.entity.User;

public class UserMapper {

    public static User mapToUser(UserCreationRequest userRequest) {

        return User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .gender(userRequest.getGender())
                .dateOfBirth(userRequest.getDateOfBirth())
                .streetAddress(userRequest.getStreetAddress())
                .city(userRequest.getCity())
                .county(userRequest.getCounty())
                .phone(userRequest.getPhone())
                .active(true)
                .deleted(false)
                .build();
    }

    public static UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .dateOfBirth(user.getDateOfBirth())
                .streetAddress(user.getStreetAddress())
                .city(user.getCity())
                .county(user.getCounty())
                .phone(user.getPhone())
                .active(user.getActive())
                .deleted(user.getDeleted())
                .createdDate(user.getCreatedDate())
                .build();
    }

    public static User mapToUser(Long id, UserUpdateRequest userRequest) {

        return User.builder()
                .id(id)
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .gender(userRequest.getGender())
                .dateOfBirth(userRequest.getDateOfBirth())
                .streetAddress(userRequest.getStreetAddress())
                .city(userRequest.getCity())
                .county(userRequest.getCounty())
                .phone(userRequest.getPhone())
                .active(userRequest.getActive())
                .deleted(userRequest.getDeleted())
                .build();
    }

}
