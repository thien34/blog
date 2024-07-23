package com.blog.core.admin.user.service;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.PasswordUpdateRequest;

public interface UserPasswordService {

    void createUserPassword(PasswordCreationRequest passwordRequest);

    void updateUserPassword(PasswordUpdateRequest updateRequest);

}
