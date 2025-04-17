package com.pipocando.domain.avaliation;

import com.pipocando.domain.movie.Movie;
import com.pipocando.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "avaliacao", nullable = false)
    private Integer rating;
    
    @Column(name = "comentario")
    private String comment;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_filme", nullable = false)
    private Movie movie;
}
