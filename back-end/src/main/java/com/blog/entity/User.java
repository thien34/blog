package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "\"user\"")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "username", length = Integer.MAX_VALUE)
    String username;

    @Column(name = "email", length = Integer.MAX_VALUE)
    String email;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    String lastName;

    @Column(name = "gender")
    Boolean gender;

    @Column(name = "date_of_birth")
    Instant dateOfBirth;

    @Column(name = "street_address", length = Integer.MAX_VALUE)
    String streetAddress;

    @Column(name = "city", length = Integer.MAX_VALUE)
    String city;

    @Column(name = "county", length = Integer.MAX_VALUE)
    String county;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    String phone;

    @Column(name = "require_re_login")
    Boolean requireReLogin;

    @Column(name = "failed_login_attempts")
    Integer failedLoginAttempts;

    @Column(name = "can_not_login_until_date")
    Instant canNotLoginUntilDate;

    @Column(name = "last_activity_date_utc")
    Instant lastActivityDateUtc;

    @Column(name = "last_login_date_utc")
    Instant lastLoginDateUtc;

    @Column(name = "active")
    Boolean active;

    @Column(name = "deleted")
    Boolean deleted;

    @ManyToMany
    @JoinTable(
            name = "user_role_mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;

}