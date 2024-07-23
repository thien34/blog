package com.blog.core.admin.permission.mapper;

import com.blog.core.admin.permission.dto.request.PermissionRequest;
import com.blog.core.admin.permission.dto.response.PermissionResponse;
import com.blog.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    Permission mapToEntity(PermissionRequest permissionRequest);

    PermissionResponse mapToDto(Permission permission);

    List<PermissionResponse> mapToDtos(List<Permission> permissions);

}
