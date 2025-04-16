package com.pipocando.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.avaliation.Avaliation;
import com.pipocando.domain.movie.Movie;
import com.pipocando.domain.user.User;

@Repository
public interface AvaliationRepository extends JpaRepository<Avaliation, Integer> {
    List<Avaliation> findByUser(User user);
    List<Avaliation> findByMovie(Movie movie);
    List<Avaliation> findByRating(Integer rating);
    Optional<Avaliation> findByUserAndMovie(User user, Movie movie);
}
