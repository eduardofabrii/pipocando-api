package com.pipocando.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipocando.dto.registration.RegistrationDTO;
import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.service.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("register")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> listAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid RegistrationDTO registrationDTO) {
        userService.registerUser(registrationDTO);
        return ResponseEntity.ok().build();
    }
}
