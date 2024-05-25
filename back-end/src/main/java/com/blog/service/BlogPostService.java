package com.blog.service;

import com.blog.dto.response.BlogPostResponse;

import java.util.List;

public interface BlogPostService {

    List<BlogPostResponse> getAll();
}
