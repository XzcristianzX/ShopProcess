package com.process.shop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;

//TROCAR
@Getter
public class AuthResponse {
    @NotBlank(message = "Email is required")
    @Email(message = "Email not valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "password min 8 characters")
    private String password;

}
