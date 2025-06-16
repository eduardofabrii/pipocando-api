package com.pipocando.domain.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer userId;
    private Integer movieId;
    private Integer serieId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(name = "url_image", nullable = true)
    private String urlImage;

    @Column(name = "category")
    private String category;
}
