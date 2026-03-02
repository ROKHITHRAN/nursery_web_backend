package com.example.nursery_web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController 
{
    private final AuthService authService;

    // 1️⃣ Register
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return authService.register(user);
    }

    // 2️⃣ Login
    @PostMapping("/login")
    public Users login(@RequestParam String email,
                       @RequestParam String password) {
        return authService.login(email, password);
    }

}
