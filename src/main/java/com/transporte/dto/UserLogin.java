package com.transporte.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLogin {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
