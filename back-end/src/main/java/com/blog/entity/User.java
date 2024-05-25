package com.blog.entity;

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

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID customerGuid;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDateTime dateOfBirth;

    private String streetAddress;

    private String city;

    private String county;

    private String phone;

    private Boolean requireReLogin;

    private Integer failedLoginAttempts;

    private LocalDateTime canNotLoginUntilDateUtc;

    private Boolean active;

    private LocalDateTime lastLoginDateUtc;

    private LocalDateTime lastActivityDateUtc;

}
