package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmailIgnoreCase(String email);
}
