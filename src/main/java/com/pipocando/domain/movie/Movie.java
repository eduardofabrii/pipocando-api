package com.pipocando.domain.movie;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome")
    private String name;

    @ElementCollection
    @Column(name = "streaming")
    private List<String> streamingPlatforms;

    @Column(name = "gravadora")
    private String company;
    
    @Column(name = "diretor")
    private String director;
    
    @ElementCollection
    @Column(name = "atores")
    private List<String> actors;
    
    @Column(name = "duracao")
    private Integer durationMinutes;
}