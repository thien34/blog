package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Auditable {

    @CreatedBy
    @Column(nullable = false, updatable = false)
    Long createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    LocalDateTime createdDate;

    @LastModifiedBy
    @Column(nullable = false)
    Long lastModifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    LocalDateTime lastModifiedDate;

}
