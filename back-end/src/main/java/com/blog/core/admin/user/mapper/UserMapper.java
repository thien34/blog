package com.blog.core.admin.user.mapper;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    @Mapping(target = "deleted", constant = "false")
    User mapToUser(UserCreationRequest userRequest);

    User mapToUser(UserUpdateRequest userRequest, @MappingTarget User user);

    UserResponse mapToUserResponse(User user);
}
