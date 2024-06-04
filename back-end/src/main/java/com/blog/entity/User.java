package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = Integer.MAX_VALUE)
    private String username;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "date_of_birth")
    private Instant dateOfBirth;

    @Column(name = "street_address", length = Integer.MAX_VALUE)
    private String streetAddress;

    @Column(name = "city", length = Integer.MAX_VALUE)
    private String city;

    @Column(name = "county", length = Integer.MAX_VALUE)
    private String county;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @Column(name = "require_re_login")
    private Boolean requireReLogin;

    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttempts;

    @Column(name = "can_not_login_until_date")
    private Instant canNotLoginUntilDate;

    @Column(name = "last_activity_date_utc")
    private Instant lastActivityDateUtc;

    @Column(name = "last_login_date_utc")
    private Instant lastLoginDateUtc;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "deleted")
    private Boolean deleted;

}