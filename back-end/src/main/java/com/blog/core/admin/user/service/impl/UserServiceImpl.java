package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.core.admin.user.mapper.UserMapper;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.core.admin.user.service.UserService;
import com.blog.core.common.PageResponse;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.infrastructure.exception.IllegalArgumentException;
import com.blog.infrastructure.exception.ResourceNotFoundException;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPasswordService userPasswordService;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void createUser(UserCreationRequest userRequest) {
        //1. save user
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new IllegalArgumentException("Username is already taken!");
        }

        roleRepository.findByName("USER").orElseGet(() ->
                roleRepository.save(Role.builder().name("USER").build()));

        User user = UserMapper.INSTANCE.mapToEntity(userRequest);
        user.setRoles(Set.of(roleRepository.findByName("USER").get()));

        user = userRepository.save(user);

        //2. save user password
        PasswordCreationRequest creationRequest = PasswordCreationRequest.builder()
                .userId(user.getId())
                .rawPassword(userRequest.getPassword())
                .build();

        userPasswordService.createUserPassword(creationRequest);
    }

    @Override
    public PageResponse<?> getUsers(String username, Integer pageNo, Integer pageSize) {
        if (pageNo < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Invalid page number or page size");
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());

        Page<User> userPage = userRepository.findByUsernameContaining(username, pageable);

        List<UserResponse> userResponses = UserMapper.INSTANCE.mapToDtos(userPage.getContent());

        return PageResponse.builder()
                .page(userPage.getNumber())
                .size(userPage.getSize())
                .totalPage(userPage.getTotalPages())
                .items(userResponses)
                .build();
    }

    @Override
    public UserResponse getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper.INSTANCE::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserResponse getUserCurrent() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        return userRepository.findByUsername(name)
                .map(UserMapper.INSTANCE::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + name));
    }

    @Override
    public void updateUser(Long id, UserUpdateRequest userRequest) {
        User existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        User userUpdate = UserMapper.INSTANCE.mapToEntity(userRequest, existingUser);
        userRepository.save(userUpdate);
    }
}
