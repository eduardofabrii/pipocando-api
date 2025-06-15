package com.pipocando.dto.request;

import com.pipocando.domain.user.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPutRequest(
    @NotBlank(message = "Nome é obrigatório")
    String name,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    String currentPassword,
    
    @Size(min = 6, message = "A nova senha precisa ter no mínimo 6 caracteres.")
    String newPassword,

    UserRole role,
    
    Boolean active
) {}
