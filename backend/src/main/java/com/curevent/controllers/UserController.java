package com.curevent.controllers;

import com.curevent.models.User;
import com.curevent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable UUID id) {
        return userRepository.findById(id).stream().findAny().orElse(null);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}