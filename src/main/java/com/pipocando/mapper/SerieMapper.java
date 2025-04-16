package com.pipocando.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.pipocando.domain.serie.Serie;
import com.pipocando.dto.response.SerieGetResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SerieMapper {
    List<SerieGetResponse> toSerieGetResponseList(List<Serie> series);
    SerieGetResponse toSerieGetResponse(Serie serie);
}
