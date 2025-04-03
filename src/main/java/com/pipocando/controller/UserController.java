package com.pipocando.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> listAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
