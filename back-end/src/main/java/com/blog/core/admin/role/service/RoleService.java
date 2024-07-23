package com.blog.core.admin.role.service;

import com.blog.core.admin.role.dto.request.RoleRequest;
import com.blog.core.admin.role.dto.response.RoleResponse;
import com.blog.core.common.PageResponse;

import java.util.List;

public interface RoleService {

    void createRole(RoleRequest roleRequest);

    PageResponse<?> getRoles(String username, Integer pageNo, Integer pageSize);

    RoleResponse getRole(Long id);

    void updateRole(Long id, RoleRequest roleRequest);

    void deleteRole(List<Long> ids);

}
