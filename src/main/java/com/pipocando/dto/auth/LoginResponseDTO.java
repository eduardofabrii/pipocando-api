package com.pipocando.dto.auth;

public record LoginResponseDTO(
    String token, 
    String userName, 
    String role,
    Integer userId
) {}