package com.pipocando.service.movie;

import java.util.List;

import com.pipocando.dto.request.MoviePostRequest;
import com.pipocando.dto.request.MoviePutRequest;
import com.pipocando.dto.response.MovieGetResponse;

public interface MovieService {
    List<MovieGetResponse> findAllMovies();
    MovieGetResponse findMovieById(Integer id);
    MovieGetResponse createMovie(MoviePostRequest moviePostRequest);
    MovieGetResponse updateMovie(Integer id, MoviePutRequest moviePutRequest);
    void deleteMovie(Integer id);
}
