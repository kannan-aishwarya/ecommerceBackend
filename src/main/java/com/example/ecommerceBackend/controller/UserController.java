package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.AddUserRequest;
import com.example.ecommerceBackend.entity.User;
import com.example.ecommerceBackend.repository.UserRepository;
import com.example.ecommerceBackend.services.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddUserService addUserService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @PostMapping("/users/signup")
    public void createUser(@RequestBody AddUserRequest request) {
        addUserService.addUser(request.getEmail());
    }
}
