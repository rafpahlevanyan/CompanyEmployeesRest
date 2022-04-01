package com.example.companyemployeesrest.repository;

import com.example.companyemployeesrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserEmail(String userEmail);

    Optional<User> findByToken(String token);

}