package com.pipocando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.blog.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
    List<Post> findByMovieId(Integer movieId);
    List<Post> findBySerieId(Integer serieId);

    @Query("SELECT p FROM Post p WHERE (:title IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
           "AND (:userId IS NULL OR p.userId = :userId) " +
           "AND (:movieId IS NULL OR p.movieId = :movieId) " +
           "AND (:serieId IS NULL OR p.serieId = :serieId)")
    List<Post> searchPosts(@Param("title") String title,
                          @Param("userId") Integer userId,
                          @Param("movieId") Integer movieId,
                          @Param("serieId") Integer serieId);

    @Query("SELECT p FROM Post p " +
           "LEFT JOIN com.pipocando.domain.user.User u ON p.userId = u.id " +
           "LEFT JOIN com.pipocando.domain.movie.Movie m ON p.movieId = m.id " +
           "LEFT JOIN com.pipocando.domain.serie.Serie s ON p.serieId = s.id " +
           "WHERE (:title IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
           "AND (:userName IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :userName, '%'))) " +
           "AND (:movieName IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))) " +
           "AND (:serieName IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :serieName, '%')))")
    List<Post> searchPostsAdvanced(@Param("title") String title,
                                   @Param("userName") String userName,
                                   @Param("movieName") String movieName,
                                   @Param("serieName") String serieName);
}
