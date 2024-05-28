package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(columnDefinition = "Boolean default false")
    private Boolean deleted = false;

    private String createdBy;

    private LocalDateTime createdTime;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedTime;

    @PrePersist
    protected void prePersist() {
        if (this.createdTime == null) createdTime = LocalDateTime.now();
        if (this.lastModifiedTime == null) lastModifiedTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.lastModifiedTime = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        this.lastModifiedTime = LocalDateTime.now();
    }
}