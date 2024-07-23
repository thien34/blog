package com.blog.core.admin.role.service.impl;

import com.blog.core.admin.role.dto.request.RoleRequest;
import com.blog.core.admin.role.dto.response.RoleResponse;
import com.blog.core.admin.role.service.RoleService;
import com.blog.core.common.PageResponse;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Override
    public void createRole(RoleRequest roleRequest) {

    }

    @Override
    public PageResponse<?> getRoles(String username, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public RoleResponse getRole(Long id) {
        return null;
    }

    @Override
    public void updateRole(Long id, RoleRequest roleRequest) {

    }

    @Override
    public void deleteRole(List<Long> ids) {

    }
}
