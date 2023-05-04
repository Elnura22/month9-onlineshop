package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailContainsIgnoringCase(String email);
    User findUserById(Long id);

}
