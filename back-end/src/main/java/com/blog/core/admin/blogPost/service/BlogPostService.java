package com.blog.core.admin.blogPost.service;

import com.blog.core.admin.blogPost.dto.request.BlogPostRequest;
import com.blog.core.admin.blogPost.dto.response.BlogPostResponse;

import java.util.List;

public interface BlogPostService {

    List<BlogPostResponse> getAll();

    BlogPostResponse getById(Long id);

    BlogPostResponse create(BlogPostRequest blogPostRequest);

    BlogPostResponse update(Long id, BlogPostRequest blogPostRequest);

    void delete(Long id);

    List<BlogPostResponse> getLatestPosts(int limit);
}
