package com.process.shop.controller;

import com.process.shop.model.dto.AuthResponse;
import com.process.shop.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthControler {
    private final AuthService service;
    @PostMapping("login")
    public ResponseEntity<AuthRequest> login(@Valid AuthResponse authResponse){
        return ResponseEntity.ok(service.login(authResponse));
    }


}
