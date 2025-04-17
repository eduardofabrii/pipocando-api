package com.pipocando.dto.update;

import com.pipocando.domain.user.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserPostRequest(
    @NotBlank(message = "Nome é obrigatório")
    String name,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,
    
    UserRole role,
    
    Boolean active
) {}
