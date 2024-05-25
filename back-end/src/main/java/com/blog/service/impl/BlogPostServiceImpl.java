package com.blog.service.impl;

import com.blog.dto.response.BlogPostResponse;
import com.blog.entity.BlogPost;
import com.blog.mapper.BlogPostMapper;
import com.blog.repository.BlogPostRepository;
import com.blog.service.BlogPostService;
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
}
