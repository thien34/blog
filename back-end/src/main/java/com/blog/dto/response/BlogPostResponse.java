package com.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostResponse {

    private Long id;
    private String title;
    private String body;
    private String bodyOverview;
    private Set<TagResponse> tag;
}


