package com.pipocando.service.user;

import java.util.List;

import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.dto.registration.RegistrationDTO;
import com.pipocando.dto.update.UserPutRequest;

public interface UserService {
    List<UserGetResponse> findAllUsers();
    UserGetResponse findUserById(Integer id);
    void updateLastLogin(String email);
    void registerUser(RegistrationDTO registrationDTO);
    void updateUser(Integer id, UserPutRequest userPutRequest);
    void deleteUser(Integer id);
    void restoreUser(Integer id);
}
