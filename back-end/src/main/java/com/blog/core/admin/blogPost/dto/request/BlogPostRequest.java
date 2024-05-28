package com.blog.core.admin.blogPost.dto.request;

import com.blog.entity.BlogPostTagMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostRequest {

    private String title;

    private String body;

    private String bodyOverview;

    private Boolean includeInSitemap;

    private Boolean allowComments;

    private String metaTitle;

    private String metaKeywords;

    private String metaDescription;

    private LocalDateTime startDateUtc;

    private LocalDateTime endDateUtc;

    private Set<BlogPostTagMapping> tags;
}
