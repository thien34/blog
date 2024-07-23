package com.blog.infrastructure.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String path;

    private String error;

    private String message;
}
