package com.blog.entity;

import jakarta.persistence.CascadeType;
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

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "blog_post")
public class BlogPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @Column(columnDefinition = "text")
    private String bodyOverview;

    @Column(nullable = false, columnDefinition = "Boolean default false")
    private Boolean includeInSitemap = false;

    @Column(nullable = false, columnDefinition = "Boolean default true")
    private Boolean allowComments = true;

    private String metaTitle;

    private String metaKeywords;

    @Column(columnDefinition = "text")
    private String metaDescription;

    @Column(nullable = false)
    private LocalDateTime startDateUtc;

    private LocalDateTime endDateUtc;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    private Set<BlogPostTagMapping> tags;

}
