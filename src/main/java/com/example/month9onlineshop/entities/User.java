package com.example.month9onlineshop.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "usr")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128)
    private String name;
    @Column(length = 128)
    private String accountName;
    @Column(length = 128)
    private String email;
    @Column(length = 128)
    private String password;

}
