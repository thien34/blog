package com.blog.core.admin.permission.service;

import com.blog.core.admin.permission.dto.request.PermissionRequest;
import com.blog.core.common.PageResponse;

import java.util.List;

public interface PermissionService {

    void addPermission(PermissionRequest request);

    PageResponse<?> getPermissions(String name, Integer pageNo, Integer pageSize);

    void deletePermission(List<Long> ids);

}
