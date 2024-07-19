package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.UserRoleMappingRequest;
import com.blog.core.admin.user.mapper.UserRoleMappingMapper;
import com.blog.core.admin.user.service.UserRoleMappingService;
import com.blog.repository.UserRoleMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleMappingServiceImpl implements UserRoleMappingService {

    private final UserRoleMappingRepository userRoleMappingRepository;

    @Override
    public void saveUserRoleMapping(UserRoleMappingRequest request) {
        userRoleMappingRepository.save(UserRoleMappingMapper.INSTANCE.mapToEntity(request));
    }
}
