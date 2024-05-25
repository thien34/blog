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
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(nullable = false, columnDefinition = "Boolean default false")
    private Boolean deleted = false;

    @Column(nullable = false)
    private String dataChangeCreatedBy;

    @Column(nullable = false)
    private LocalDateTime dataChangeCreatedTime;

    private String dataChangeLastModifiedBy;

    private LocalDateTime  dataChangeLastModifiedTime;

    @PrePersist
    protected void prePersist() {
        if (this.dataChangeCreatedTime == null) dataChangeCreatedTime = LocalDateTime.now();
        if (this.dataChangeLastModifiedTime == null) dataChangeLastModifiedTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.dataChangeLastModifiedTime = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        this.dataChangeLastModifiedTime = LocalDateTime.now();
    }
}