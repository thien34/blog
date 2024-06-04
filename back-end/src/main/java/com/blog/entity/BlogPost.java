package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "body", length = Integer.MAX_VALUE)
    private String body;

    @Column(name = "include_in_sitemap")
    private Boolean includeInSitemap;

    @Column(name = "body_overview", length = Integer.MAX_VALUE)
    private String bodyOverview;

    @Column(name = "allow_comments")
    private Boolean allowComments;

    @Column(name = "start_date_utc")
    private Instant startDateUtc;

    @Column(name = "end_date_utc")
    private Instant endDateUtc;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "blogPost")
    private Set<BlogPostTagMapping> blogPostTagMappings = new LinkedHashSet<>();

}