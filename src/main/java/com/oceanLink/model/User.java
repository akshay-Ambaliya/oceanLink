package com.oceanLink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user") // make sure table name matches DB
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phno")
    private String phno;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    public User(String fullName, String email, String phno, String password, String address) {
        this.fullName = fullName;
        this.email = email;
        this.phno = phno;
        this.password = password;
        this.address = address;
    }
}

