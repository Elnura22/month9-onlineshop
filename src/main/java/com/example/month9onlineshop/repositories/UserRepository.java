package com.example.month9onlineshop.repositories;

import com.example.month9onlineshop.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);
    List<User> findByAccountName(String accountName);
    List<User> findByName(String name);

    boolean existsUserByEmail(String email);

    @Query(value = "SELECT u FROM User u")
    List<User> findAllUsers(Sort sort);

//    List<User> f

    @Override
    Optional<User> findById(Long id);
}
