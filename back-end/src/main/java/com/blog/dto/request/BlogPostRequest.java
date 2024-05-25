package com.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private Boolean deleted;
    private String metaTitle;
    private String metaKeywords;
    private String metaDescription;
    private LocalDateTime startDateUtc;
    private LocalDateTime endDateUtc;
}
