package com.transporte.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.dto.UserLogin;
import com.transporte.models.ResponseService;
import com.transporte.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseService> login(@RequestBody @Valid UserLogin userLogin) {
        ResponseService response = authService.login(userLogin);
        return new ResponseEntity<ResponseService>(response, HttpStatus.OK);
    }
    
}
