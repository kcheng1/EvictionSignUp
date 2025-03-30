package com.zyu.expulsion.submit.form.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "created_datetime")
    private Date createdDate;

    @Column(name = "modified_datetime")
    private Date modifiedDate;

    @Column(name = "locked_datetime")
    private Date lockedDate;

    @Column(name = "expired_datetime")
    private Date expiredDate;

    @Column(name = "last_login_datetime")
    private Date lastLoginDate;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "status")
    private String status;

    @Column(name = "login_attempts")
    private int loginAttempts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return userName;
    }
}
