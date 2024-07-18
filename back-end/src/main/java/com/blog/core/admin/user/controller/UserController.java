package com.blog.core.admin.user.controller;

import com.blog.core.admin.user.dto.request.UserCreationRequest;
import com.blog.core.admin.user.dto.request.UserUpdateRequest;
import com.blog.core.admin.user.dto.response.UserResponse;
import com.blog.core.admin.user.service.UserService;
import com.blog.core.common.PageResponse;
import com.blog.core.common.ResponseData;
import com.blog.core.common.ResponseError;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/users")
@RestController()
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseData<?> createUser(@RequestBody @Valid UserCreationRequest userRequest) {
        try {
            userService.createUser(userRequest);
            return new ResponseData<>(HttpStatus.OK.value(), "User created successfully");
        } catch (Exception e) {
            log.error("Error creating user", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @GetMapping()
    public ResponseData<?> getUsers(@RequestParam(defaultValue = "") String username,
                                    @RequestParam(defaultValue = "0") int pageNo,
                                    @RequestParam(defaultValue = "6") int pageSize) {
        try {
            PageResponse<?> response = userService.getUsers(username, pageNo, pageSize);
            return new ResponseData<>(HttpStatus.OK.value(), "Users retrieved successfully", response);
        } catch (Exception e) {
            log.error("Error getting users", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseData<?> getUser(@PathVariable Long id) {
        try {
            UserResponse userResponse = userService.getUser(id);
            return new ResponseData<>(HttpStatus.OK.value(), "User retrieved successfully", userResponse);
        } catch (Exception e) {
            log.error("Error getting user", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @GetMapping("/current")
    public ResponseData<?> getUserCurrent() {
        try {
            UserResponse userResponse = userService.getUserCurrent();
            return new ResponseData<>(HttpStatus.OK.value(), "User retrieved successfully", userResponse);
        } catch (Exception e) {
            log.error("Error getting user", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest userRequest) {
        log.info("Request to update user with id, {}, {}", id, userRequest);
        try {
            userService.updateUser(id, userRequest);
            return new ResponseData<>(HttpStatus.OK.value(), "User updated successfully");
        } catch (Exception e) {
            log.error("Error updating user", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
}
