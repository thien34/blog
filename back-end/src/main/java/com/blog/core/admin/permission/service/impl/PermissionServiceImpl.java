package com.blog.core.admin.permission.service.impl;

import com.blog.core.admin.permission.dto.request.PermissionRequest;
import com.blog.core.admin.permission.dto.response.PermissionResponse;
import com.blog.core.admin.permission.mapper.PermissionMapper;
import com.blog.core.admin.permission.service.PermissionService;
import com.blog.core.common.PageResponse;
import com.blog.entity.Permission;
import com.blog.infrastructure.exception.IllegalArgumentException;
import com.blog.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public void addPermission(PermissionRequest request) {
        Permission permission = PermissionMapper.INSTANCE.mapToEntity(request);
        permissionRepository.save(permission);
    }

    @Override
    public PageResponse<?> getPermissions(String name, Integer pageNo, Integer pageSize) {

        if (pageNo < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Invalid page number or page size");
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());

        Page<Permission> permissionPage = permissionRepository.findByNameContaining(name, pageable);

        List<PermissionResponse> permissionResponses = PermissionMapper.INSTANCE.mapToDtos(permissionPage.getContent());

        return PageResponse.builder()
                .page(permissionPage.getNumber())
                .size(permissionPage.getSize())
                .totalPage(permissionPage.getTotalPages())
                .items(permissionResponses)
                .build();

    }

    @Override
    public void deletePermission(List<Long> ids) {
        permissionRepository.deleteAllByIdInBatch(ids);
    }
}
