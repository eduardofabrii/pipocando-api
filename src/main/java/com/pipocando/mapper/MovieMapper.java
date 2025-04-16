package com.pipocando.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.pipocando.domain.movie.Movie;
import com.pipocando.dto.response.MovieGetResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {
    List<MovieGetResponse> toMovieGetResponseList(List<Movie> movies);
    MovieGetResponse toMovieGetResponse(Movie movie);
}
