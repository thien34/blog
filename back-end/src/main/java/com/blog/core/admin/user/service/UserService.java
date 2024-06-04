package com.blog.core.admin.user.service;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    void createUser(UserCreationRequest userRequest);

    List<UserResponse> getUsers();

    UserResponse getUser(Long id);

    UserResponse updateUser(Long id, UserUpdateRequest userRequest);

}
