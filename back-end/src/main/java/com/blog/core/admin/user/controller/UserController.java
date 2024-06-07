package com.blog.core.admin.user.controller;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.service.UserService;
import com.blog.core.common.ResponseData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseData<?> createUser(@RequestBody @Valid UserCreationRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseData.builder()
                .status(201)
                .message("User created successfully")
                .build();
    }

    @GetMapping()
    public ResponseData<?> getUsers() {
        return ResponseData.builder()
                .status(200)
                .message("Users retrieved successfully")
                .data(userService.getUsers())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> getUser(@PathVariable Long id) {
        return ResponseData.builder()
                .status(200)
                .message("User retrieved successfully")
                .data(userService.getUser(id))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest userRequest) {
        userService.updateUser(id, userRequest);
        return ResponseData.builder()
                .status(200)
                .message("User updated successfully")
                .build();
    }


}
