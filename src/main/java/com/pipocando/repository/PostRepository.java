package com.pipocando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.blog.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
    List<Post> findByMovieId(Integer movieId);
    List<Post> findBySerieId(Integer serieId);
}
