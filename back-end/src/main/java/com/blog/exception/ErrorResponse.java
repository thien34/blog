package com.blog.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String path;

    private String error;

    private String message;
}
