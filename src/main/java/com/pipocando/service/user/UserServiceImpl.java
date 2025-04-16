package com.pipocando.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pipocando.domain.user.User;
import com.pipocando.domain.user.UserRole;
import com.pipocando.dto.registration.RegistrationDTO;
import com.pipocando.dto.response.UserGetResponse;
import com.pipocando.dto.update.UserPutRequest;
import com.pipocando.mapper.UserMapper;
import com.pipocando.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public List<UserGetResponse> findAllUsers() {
        List<User> users = userRepository.findByDeletedAtIsNull();
        return mapper.toUserGetResponseList(users);
    }
    
    @Override
    public UserGetResponse findUserById(Integer id) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        return mapper.toUserGetResponse(user);
    }

    @Override
    public void updateLastLogin(String email) {
        User user = (User) userRepository.findByEmail(email);
        if (user != null) {
            user.setLastLogin(java.time.LocalDateTime.now());
            userRepository.save(user);
        }
    }

    @Override
    public void registerUser(RegistrationDTO registrationDTO) {
        if (userRepository.findByEmail(registrationDTO.email()) != null) {
            throw new IllegalArgumentException("E-mail já utilizado anteriormente!");
        }

        User user = new User();
        user.setName(registrationDTO.name());
        user.setEmail(registrationDTO.email());
        user.setPassword(passwordEncoder.encode(registrationDTO.password()));
        user.setRole(UserRole.USER);
        user.setActive(true);

        userRepository.save(user);
    }
    
    @Override
    public void updateUser(Integer id, UserPutRequest userPutRequest) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        
        User existingUserWithEmail = (User) userRepository.findByEmail(userPutRequest.email());
        if (existingUserWithEmail != null && !existingUserWithEmail.getId().equals(id)) {
            throw new IllegalArgumentException("E-mail já utilizado por outro usuário!");
        }
        
        user.setName(userPutRequest.name());
        user.setEmail(userPutRequest.email());
        user.setRole(userPutRequest.role());
        user.setActive(userPutRequest.active());
        
        userRepository.save(user);
    }
    
    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        
        user.setDeletedAt(LocalDateTime.now());
        user.setActive(false);
        
        userRepository.save(user);
    }
    
    @Override
    public void restoreUser(Integer id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        
        if (user.getDeletedAt() == null) {
            throw new IllegalStateException("O usuário não está excluído");
        }
        
        user.setDeletedAt(null);
        user.setActive(true);
        
        userRepository.save(user);
    }
}
