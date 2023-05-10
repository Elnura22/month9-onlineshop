package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username can only contain letters and numbers")
    @Column(length = 128)
    private String name;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 4)
    @Column(length = 128)
    private String accountName;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(min = 3, max = 128, message = "Length must be > 3 and < 128")
    @Column(length = 128)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 24)
    @Column(length = 128)
    private String password;

}
