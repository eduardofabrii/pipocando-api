package com.pipocando.service.user;

import java.util.List;

import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.dto.request.RegistrationRequest;
import com.pipocando.dto.request.UserPutRequest;

public interface UserService {
    List<UserGetResponse> findAllUsers();
    UserGetResponse findUserById(Integer id);
    void updateLastLogin(String email);
    void registerUser(RegistrationRequest registrationDTO);
    UserGetResponse updateUser(Integer id, UserPutRequest userPutRequest);
    void deleteUser(Integer id);
    void restoreUser(Integer id);
}
