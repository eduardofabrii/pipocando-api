package com.pipocando.domain.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "senha")
    private String password;
    
    @Column(name = "data_criacao", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime creationDate;
    
    @Column(name = "ultimo_login")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastLogin;
    
    @Column(name = "perfil")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "ativo")
    private Boolean active = true;
}
