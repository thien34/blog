package com.blog.mapper;

import com.blog.dto.response.BlogPostResponse;
import com.blog.dto.response.TagResponse;
import com.blog.entity.BlogPost;
import com.blog.entity.BlogPostTagMapping;

import java.util.Set;
import java.util.stream.Collectors;

public class BlogPostMapper {

    private BlogPostMapper() {
    }

    public static BlogPostResponse toDto(BlogPost blogPost) {
        Set<BlogPostTagMapping> tags = blogPost.getTags();
        Set<TagResponse> tagResponses = tags.stream()
                .map(map -> new TagResponse(map.getTag().getId(), map.getTag().getName()))
                .collect(Collectors.toSet());
        return BlogPostResponse.builder()
                .id(blogPost.getId())
                .title(blogPost.getTitle())
                .body(blogPost.getBody())
                .tag(tagResponses)
                .build();
    }

}