package com.pipocando.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pipocando.repository.UserRepository;

import lombok.AllArgsConstructor;

/**
 * Classe de serviço para manipulação de autorização de usuários.
 * Implementa a interface UserDetailsService para fornecer detalhes do usuário com base no email.
 */
@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

}