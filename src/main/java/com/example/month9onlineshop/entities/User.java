package com.example.month9onlineshop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usr")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is mandatory")
    @Column(length = 128)
    private String name;

    @NotBlank(message = "Account name is mandatory")
 //   @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Account name can contains only letters and numbers")
    @Size(min = 4, max = 128)
    @Column(length = 128)
    private String accountName;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(min = 8, max = 128)
    @Column(length = 128)
    private String email;

    @NotBlank(message = "Password is mandatory")
 //   @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contains only letters and numbers")
//    @Size(min = 8, max = 24)
    @Column(length = 128)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
