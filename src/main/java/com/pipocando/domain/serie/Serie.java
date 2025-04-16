package com.pipocando.domain.serie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome")
    private String name;

    @Column(name = "streaming")
    private String streaming;

    @Column(name = "gravadora")
    private String company;
    
    @Column(name = "diretor")
    private String director;
    
    @Column(name = "atores")
    private String actors;
    
    @Column(name = "temporadas")
    private Integer seasons;
}