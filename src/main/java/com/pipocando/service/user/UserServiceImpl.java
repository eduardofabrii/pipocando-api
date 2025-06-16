package com.pipocando.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pipocando.domain.user.User;
import com.pipocando.domain.user.UserRole;
import com.pipocando.dto.request.RegistrationRequest;
import com.pipocando.dto.request.UserPutRequest;
import com.pipocando.dto.response.UserGetResponse;
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
    public void registerUser(RegistrationRequest registrationDTO) {
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
    public UserGetResponse updateUser(Integer id, UserPutRequest userPutRequest) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        
        // Validar email único
        User existingUserWithEmail = (User) userRepository.findByEmail(userPutRequest.email());
        if (existingUserWithEmail != null && !existingUserWithEmail.getId().equals(id)) {
            throw new IllegalArgumentException("E-mail já utilizado por outro usuário!");
        }
        
        // Atualizar dados básicos
        user.setName(userPutRequest.name());
        user.setEmail(userPutRequest.email());
        
        // Se fornecido role e o usuário atual for ADMIN, atualizar papel
        if (userPutRequest.role() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (currentUser instanceof User && ((User) currentUser).getRole() == UserRole.ADMIN) {
                user.setRole(userPutRequest.role());
                // Apenas admins podem mudar status active
                if (userPutRequest.active() != null) {
                    user.setActive(userPutRequest.active());
                }
            }
        }
        
        // Processar alteração de senha
        if (userPutRequest.newPassword() != null && !userPutRequest.newPassword().isEmpty()) {
            // Validar senha atual
            if (userPutRequest.currentPassword() == null || !passwordEncoder.matches(userPutRequest.currentPassword(), user.getPassword())) {
                throw new IllegalArgumentException("Senha atual incorreta");
            }
            
            // Definir nova senha
            user.setPassword(passwordEncoder.encode(userPutRequest.newPassword()));
        }
        
        // Salvar alterações
        User updatedUser = userRepository.save(user);
        
        // Retornar dados atualizados
        return mapper.toUserGetResponse(updatedUser);
    }
    
    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
        
        // user.setDeletedAt(LocalDateTime.now());
        // user.setActive(false);
        // userRepository.save(user);

        userRepository.delete(user);
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
