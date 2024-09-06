package com.transporte.services;

import com.transporte.dto.UserLogin;
import com.transporte.models.ResponseService;

import jakarta.validation.Valid;

public interface AuthService {

    ResponseService login(@Valid UserLogin userLogin);

}
