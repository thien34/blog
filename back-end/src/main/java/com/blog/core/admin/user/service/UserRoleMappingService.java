package com.blog.core.admin.user.service;

import com.blog.core.admin.user.dto.request.UserRoleMappingRequest;

public interface UserRoleMappingService {

    void saveUserRoleMapping(UserRoleMappingRequest request);

}
