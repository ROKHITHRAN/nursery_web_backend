package com.example.nursery_web.controller;

import org.springframework.web.bind.annotation.*;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1️⃣ Register
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    // 2️⃣ Login
    @PostMapping("/login")
    public Users login(@RequestParam String email,
                       @RequestParam String password) {
        return userService.login(email, password);
    }

    // 3️⃣ Get User Details
    @GetMapping("/{id}")
    public Users getUserDetails(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}