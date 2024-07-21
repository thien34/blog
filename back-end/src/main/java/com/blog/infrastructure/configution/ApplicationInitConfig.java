package com.blog.infrastructure.configution;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.dto.request.UserRoleMappingRequest;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.core.admin.user.service.UserRoleMappingService;
import com.blog.entity.User;
import com.blog.infrastructure.constant.Role;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {

    private final UserRepository userRepository;
    private final UserPasswordService userPasswordService;
    private final UserRoleMappingService userRoleMappingService;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            if (userRepository.findByUsername(Role.ADMIN.getName().toLowerCase()).isEmpty()) {
                log.info("Creating default admin user");
                //
                User user = User.builder()
                        .username(Role.ADMIN.getName().toLowerCase())
                        .build();
                User userSaved = userRepository.save(user);

                //
                UserRoleMappingRequest roleMappingRequest = UserRoleMappingRequest.builder()
                        .userId(userSaved.getId())
                        .roleId(Role.ADMIN.getId())
                        .build();
                userRoleMappingService.saveUserRoleMapping(roleMappingRequest);

                //
                PasswordCreationRequest creationRequest = PasswordCreationRequest.builder()
                        .userId(userSaved.getId())
                        .rawPassword(Role.ADMIN.getName().toLowerCase())
                        .build();
                userPasswordService.createUserPassword(creationRequest);
            }
        };
    }
}
