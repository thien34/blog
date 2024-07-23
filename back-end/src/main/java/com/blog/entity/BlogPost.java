package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    String title;

    @Column(name = "body", length = Integer.MAX_VALUE)
    String body;

    @Column(name = "include_in_sitemap")
    Boolean includeInSitemap;

    @Column(name = "body_overview", length = Integer.MAX_VALUE)
    String bodyOverview;

    @Column(name = "allow_comments")
    Boolean allowComments;

    @Column(name = "start_date_utc")
    Instant startDateUtc;

    @Column(name = "end_date_utc")
    Instant endDateUtc;

    @Column(name = "deleted")
    Boolean deleted;

    @OneToMany(mappedBy = "blogPost")
    Set<BlogPostTagMapping> blogPostTagMappings = new LinkedHashSet<>();

}