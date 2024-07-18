package com.blog.infrastructure.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN(1L, "ADMIN"),
    USER(2L, "USER");

    private final Long id;
    private final String name;
}
