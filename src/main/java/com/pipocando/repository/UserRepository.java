package com.pipocando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    UserDetails findByName(String name);
    UserDetails findByEmail(String email);
}
