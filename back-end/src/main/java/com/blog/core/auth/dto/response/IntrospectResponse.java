package com.blog.core.auth.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IntrospectResponse {

    boolean valid;

}
