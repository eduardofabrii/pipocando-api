package com.pipocando.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipocando.domain.user.User;
import com.pipocando.dto.auth.AuthenticationDTO;
import com.pipocando.dto.auth.LoginResponseDTO;
import com.pipocando.service.security.TokenService;
import com.pipocando.service.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto) {
        var userPassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = this.authenticationManager.authenticate(userPassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        userService.updateLastLogin(dto.email());
        
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
