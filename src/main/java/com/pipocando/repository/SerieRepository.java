package com.pipocando.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.serie.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    List<Serie> findByName(String name);
    List<Serie> findByDirector(String director);
    List<Serie> findByCompany(String company);
    List<Serie> findByStreaming(String streaming);
    Optional<Serie> findById(Integer id);
}
