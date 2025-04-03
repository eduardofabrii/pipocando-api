package com.pipocando.service.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pipocando.domain.user.User;
import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.mapper.UserMapper;
import com.pipocando.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public List<UserGetResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        return mapper.toUserGetResponseList(users);
    }

    @Override
    public void updateLastLogin(String email) {
        User user = (User) userRepository.findByEmail(email);
        if (user != null) {
            user.setLastLogin(java.time.LocalDateTime.now());
            userRepository.save(user);
        }
    }
}
