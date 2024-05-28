package com.blog.core.admin.blogPost.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostResponse {

    private Long id;

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

    private Set<TagResponse> tag;

}



