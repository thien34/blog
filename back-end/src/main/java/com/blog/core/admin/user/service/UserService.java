package com.blog.core.admin.user.service;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.core.common.PageResponse;

public interface UserService {

    void createUser(UserCreationRequest userRequest);

    PageResponse<?> getUsers(String username, int pageNo, int pageSize);

    UserResponse getUser(Long id);

    void updateUser(Long id, UserUpdateRequest userRequest);

}
