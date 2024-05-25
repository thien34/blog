package com.blog.dto.response;

import com.blog.entity.BlogPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogPostResponse {

    private Long id;
    private String title;
    private String body;

    public static BlogPostResponse toDTO(BlogPost blogPost) {
        return BlogPostResponse.builder()
                .id(blogPost.getId())
                .title(blogPost.getTitle())
                .body(blogPost.getBody())
                .build();
    }
}


