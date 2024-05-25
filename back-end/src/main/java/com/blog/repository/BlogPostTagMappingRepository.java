package com.blog.repository;

import com.blog.entity.BlogPostTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostTagMappingRepository extends JpaRepository<BlogPostTagMapping, Long> {

}
