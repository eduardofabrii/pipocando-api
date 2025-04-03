package com.pipocando.service.user;

import java.util.List;

import com.pipocando.dto.response.UserGetResponse;

public interface UserService {
    List<UserGetResponse> findAllUsers();
    void updateLastLogin(String email);
}
