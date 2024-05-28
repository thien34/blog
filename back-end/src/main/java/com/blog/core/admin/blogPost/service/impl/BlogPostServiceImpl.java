package com.blog.core.admin.blogPost.service.impl;

import com.blog.core.admin.blogPost.dto.request.BlogPostRequest;
import com.blog.core.admin.blogPost.dto.response.BlogPostResponse;
import com.blog.entity.BlogPost;
import com.blog.exception.ResourceNotFoundException;
import com.blog.core.admin.blogPost.mapper.BlogPostMapper;
import com.blog.repository.BlogPostRepository;
import com.blog.core.admin.blogPost.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public List<BlogPostResponse> getAll() {
        List<BlogPost> list = blogPostRepository.findAll();
        return list.stream().map(BlogPostMapper::toDto).toList();
    }

    @Override
    public BlogPostResponse getById(Long id) {
        return blogPostRepository
                .findById(id)
                .map(BlogPostMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost not found with id: " + id));
    }

    @Override
    public BlogPostResponse create(BlogPostRequest blogPostRequest) {
        BlogPost blogPost = BlogPostMapper.toEntity(blogPostRequest);
        blogPostRepository.save(blogPost);
        return BlogPostMapper.toDto(blogPost);
    }

    @Override
    public BlogPostResponse update(Long id, BlogPostRequest blogPostRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<BlogPostResponse> getLatestPosts(int limit) {
        return List.of();
    }

}
