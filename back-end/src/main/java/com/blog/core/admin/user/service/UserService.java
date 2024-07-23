package com.blog.core.admin.user.service;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.core.common.PageResponse;

public interface UserService {

    void createUser(UserCreationRequest userRequest);

    PageResponse<?> getUsers(String username, Integer pageNo, Integer pageSize);

    UserResponse getUser(Long id);

    UserResponse getUserCurrent();

    void updateUser(Long id, UserUpdateRequest userRequest);

}
