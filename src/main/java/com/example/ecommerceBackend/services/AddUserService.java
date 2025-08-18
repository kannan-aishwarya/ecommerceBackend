package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.entity.AddUserRequest;
import com.example.ecommerceBackend.entity.User;
import com.example.ecommerceBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(String name, String phoneNumber, String addressLine1, String addressLine2) {
        User user = new User(name,phoneNumber,addressLine1,addressLine2);
        userRepository.save(user);
    }
}
