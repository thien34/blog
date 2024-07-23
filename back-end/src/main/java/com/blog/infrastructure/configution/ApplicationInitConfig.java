package com.blog.infrastructure.configution;

import com.blog.core.admin.user.dto.request.PasswordCreationRequest;
import com.blog.core.admin.user.service.UserPasswordService;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.infrastructure.constant.RoleUser;
import com.blog.infrastructure.exception.ResourceNotFoundException;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserPasswordService userPasswordService;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            if (userRepository.findByUsername(RoleUser.ADMIN.getName().toLowerCase()).isEmpty()) {
                log.info("Creating default admin user");

                // save role
                if (!roleRepository.existsByName(RoleUser.ADMIN.getName())) {
                    Role role = Role.builder()
                            .name(RoleUser.ADMIN.getName())
                            .active(true)
                            .build();
                    roleRepository.save(role);
                }

                // save user
                Set<Role> roles = Set.of(roleRepository.findByName(RoleUser.ADMIN.getName())
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found")));

                User user = User.builder()
                        .username(RoleUser.ADMIN.getName().toLowerCase())
                        .roles(roles)
                        .build();
                User userSaved = userRepository.save(user);

                // save password
                PasswordCreationRequest creationRequest = PasswordCreationRequest.builder()
                        .userId(userSaved.getId())
                        .rawPassword(RoleUser.ADMIN.getName().toLowerCase())
                        .build();
                userPasswordService.createUserPassword(creationRequest);
            }
        };
    }
}
