package com.blog.mapper;

import com.blog.dto.response.BlogPostResponse;
import com.blog.dto.response.TagResponse;
import com.blog.entity.BlogPost;
import com.blog.entity.BlogPostTagMapping;

import java.util.Set;
import java.util.stream.Collectors;

public class BlogPostMapper {

    private BlogPostMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static BlogPostResponse toDto(BlogPost blogPost) {
        return BlogPostResponse.builder()
                .id(blogPost.getId())
                .title(blogPost.getTitle())
                .body(blogPost.getBody())
                .bodyOverview(blogPost.getBodyOverview())
                .tag(mapTags(blogPost.getTags()))
                .build();
    }

    private static Set<TagResponse> mapTags(Set<BlogPostTagMapping> tags) {
        return tags.stream()
                .map(map -> new TagResponse(map.getTag().getId(), map.getTag().getName()))
                .collect(Collectors.toSet());
    }

}