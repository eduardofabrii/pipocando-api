package com.pipocando.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByName(String name);
    List<Movie> findByDirector(String director);
    List<Movie> findByCompany(String company);
    Optional<Movie> findById(Integer id);
}
