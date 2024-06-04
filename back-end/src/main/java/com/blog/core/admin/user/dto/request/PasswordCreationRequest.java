package com.blog.core.admin.user.dto.request;

import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PasswordCreationRequest {

    private User user;

    private String rawPassword;

}
