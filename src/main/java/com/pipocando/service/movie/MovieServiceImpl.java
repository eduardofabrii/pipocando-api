package com.pipocando.service.movie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pipocando.domain.movie.Movie;
import com.pipocando.dto.request.MoviePostRequest;
import com.pipocando.dto.request.MoviePutRequest;
import com.pipocando.dto.response.MovieGetResponse;
import com.pipocando.mapper.MovieMapper;
import com.pipocando.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieGetResponse> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.toMovieGetResponseList(movies);
    }

    @Override
    public MovieGetResponse findMovieById(Integer id) {
        Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + id));
        return movieMapper.toMovieGetResponse(movie);
    }

    @Override
    public MovieGetResponse createMovie(MoviePostRequest moviePostRequest) {
        Movie movie = new Movie();
        movie.setName(moviePostRequest.name());
        movie.setStreamingPlatforms(moviePostRequest.streamingPlatforms());
        movie.setCompany(moviePostRequest.company());
        movie.setDirector(moviePostRequest.director());
        movie.setActors(moviePostRequest.actors());
        movie.setDurationMinutes(moviePostRequest.durationMinutes());
        
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toMovieGetResponse(savedMovie);
    }

    @Override
    public MovieGetResponse updateMovie(Integer id, MoviePutRequest moviePutRequest) {
        Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + id));
        
        movie.setName(moviePutRequest.name());
        movie.setStreamingPlatforms(moviePutRequest.streamingPlatforms());
        movie.setCompany(moviePutRequest.company());
        movie.setDirector(moviePutRequest.director());
        movie.setActors(moviePutRequest.actors());
        movie.setDurationMinutes(moviePutRequest.durationMinutes());
        
        Movie updatedMovie = movieRepository.save(movie);
        return movieMapper.toMovieGetResponse(updatedMovie);
    }

    @Override
    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + id));
        
        movieRepository.delete(movie);
    }
}
