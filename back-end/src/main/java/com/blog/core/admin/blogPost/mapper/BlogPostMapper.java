package com.blog.core.admin.blogPost.mapper;

import com.blog.core.admin.blogPost.dto.request.BlogPostRequest;
import com.blog.core.admin.blogPost.dto.response.BlogPostResponse;
import com.blog.core.admin.blogPost.dto.response.TagResponse;
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
                .includeInSitemap(blogPost.getIncludeInSitemap())
                .allowComments(blogPost.getAllowComments())
                .metaTitle(blogPost.getMetaTitle())
                .metaKeywords(blogPost.getMetaKeywords())
                .metaDescription(blogPost.getMetaDescription())
                .startDateUtc(blogPost.getStartDateUtc())
                .endDateUtc(blogPost.getEndDateUtc())
                .tag(mapTags(blogPost.getTags()))
                .build();
    }

    public static BlogPost toEntity(BlogPostRequest blogPostRequest){
        return BlogPost.builder()
                .title(blogPostRequest.getTitle())
                .body(blogPostRequest.getBody())
                .bodyOverview(blogPostRequest.getBodyOverview())
                .includeInSitemap(blogPostRequest.getIncludeInSitemap())
                .allowComments(blogPostRequest.getAllowComments())
                .metaKeywords(blogPostRequest.getMetaKeywords())
                .metaTitle(blogPostRequest.getMetaTitle())
                .metaDescription(blogPostRequest.getMetaDescription())
                .startDateUtc(blogPostRequest.getStartDateUtc())
                .endDateUtc(blogPostRequest.getEndDateUtc())
                .tags(blogPostRequest.getTags())
                .build();
    }

    private static Set<TagResponse> mapTags(Set<BlogPostTagMapping> tags) {
        return tags.stream()
                .map(map -> new TagResponse(map.getTag().getId(), map.getTag().getName()))
                .collect(Collectors.toSet());
    }

}