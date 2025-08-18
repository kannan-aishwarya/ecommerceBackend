package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
