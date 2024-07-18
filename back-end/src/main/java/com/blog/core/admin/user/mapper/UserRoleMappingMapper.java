package com.blog.core.admin.user.mapper;

import com.blog.core.admin.user.dto.request.UserRoleMappingRequest;
import com.blog.entity.User;
import com.blog.entity.UserRole;
import com.blog.entity.UserUserRoleMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRoleMappingMapper {

    UserRoleMappingMapper INSTANCE = Mappers.getMapper(UserRoleMappingMapper.class);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "roleId", target = "userRole")
    UserUserRoleMapping mapToEntity(UserRoleMappingRequest request);

    default User mapUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }

    default UserRole mapUserRole(Long roleId) {
        if (roleId == null) {
            return null;
        }
        UserRole userRole = new UserRole();
        userRole.setId(roleId);
        return userRole;
    }

}
