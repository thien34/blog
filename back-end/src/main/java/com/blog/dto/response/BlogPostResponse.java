package com.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BlogPostResponse {

    private Long id;
    private String title;
    private String body;
    private Set<TagResponse> tag;
}


