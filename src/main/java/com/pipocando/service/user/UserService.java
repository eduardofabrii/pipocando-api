package com.pipocando.service.user;

import java.util.List;

import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.dto.registration.RegistrationDTO;

public interface UserService {
    List<UserGetResponse> findAllUsers();
    void updateLastLogin(String email);
    void registerUser(RegistrationDTO registrationDTO);
}
