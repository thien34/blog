package com.blog.core.admin.user.mapper;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.entity.Role;
import com.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "active", constant = "true")
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "roles", ignore = true)
    User mapToEntity(UserCreationRequest userRequest);

    User mapToEntity(UserUpdateRequest userRequest, @MappingTarget User user);

    @Mapping(source = "roles", target = "userRole")
    UserResponse mapToDto(User user);

    List<UserResponse> mapToDtos(List<User> users);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
