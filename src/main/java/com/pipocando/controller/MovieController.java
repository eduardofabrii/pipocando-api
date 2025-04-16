package com.pipocando.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipocando.dto.request.MoviePostRequest;
import com.pipocando.dto.request.MoviePutRequest;
import com.pipocando.dto.response.MovieGetResponse;
import com.pipocando.service.movie.MovieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieGetResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieGetResponse> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping
    public ResponseEntity<MovieGetResponse> createMovie(@RequestBody @Valid MoviePostRequest moviePostRequest) {
        MovieGetResponse createdMovie = movieService.createMovie(moviePostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieGetResponse> updateMovie(
            @PathVariable Integer id,
            @RequestBody @Valid MoviePutRequest moviePutRequest) {
        MovieGetResponse updatedMovie = movieService.updateMovie(id, moviePutRequest);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
