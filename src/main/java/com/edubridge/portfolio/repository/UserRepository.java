package com.edubridge.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.portfolio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
<<<<<<< HEAD

    Optional<User> findBySlug(String slug);
=======
>>>>>>> 534ee4228c24018e013d0b7a7d7aeddc93502469
}