package com.blog.core.admin.blogPost.controller;

import com.blog.core.admin.blogPost.dto.request.BlogPostRequest;
import com.blog.core.admin.blogPost.dto.response.BlogPostResponse;
import com.blog.core.admin.blogPost.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("")
    public List<BlogPostResponse> getAll() {
        return blogPostService.getAll();
    }

    @GetMapping("{id}")
    public BlogPostResponse getById(@PathVariable Long id) {
        return blogPostService.getById(id);
    }

    @PostMapping("")
    public BlogPostResponse save(@RequestBody BlogPostRequest blogPostRequest) {
        return blogPostService.create(blogPostRequest);
    }

}
