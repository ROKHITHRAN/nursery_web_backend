package com.example.nursery_web.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nursery_web.model.Users;
import com.example.nursery_web.service.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        String token = authService.login(email, password);

        return ResponseEntity.ok(Map.of("token", token));
    }
}