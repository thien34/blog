package com.blog.core.admin.user.service.impl;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.core.admin.user.mapper.UserMapper;
import com.blog.core.admin.user.repository.UserRepository;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.core.admin.user.service.UserService;
import com.blog.entity.User;
import com.blog.infrastructure.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPasswordService userPasswordService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserPasswordService userPasswordService) {
        this.userRepository = userRepository;
        this.userPasswordService = userPasswordService;
    }

    @Override
    @Transactional
    public void createUser(UserCreationRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = userRepository.save(UserMapper.mapToUser(userRequest));

        PasswordCreationRequest creationRequest = PasswordCreationRequest.builder()
                .user(user)
                .rawPassword(userRequest.getPassword())
                .build();

        userPasswordService.createUserPassword(creationRequest);
    }

    @Override
    public List<UserResponse> getUsers() {

        List<User> list = userRepository.findAll();

        return list.stream().map(UserMapper::mapToUserResponse).toList();
    }

    @Override
    public UserResponse getUser(Long id) {

        Optional<User> user = userRepository.findById(id);

        return user.map(UserMapper::mapToUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        BeanUtils.copyProperties(userRequest, user, "id", "username", "email");

        User userUpdate = userRepository.save(user);

        return UserMapper.mapToUserResponse(userUpdate);
    }
}
