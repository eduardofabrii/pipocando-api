package com.pipocando.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.pipocando.domain.avaliation.Avaliation;
import com.pipocando.dto.response.AvaliationGetResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AvaliationMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "movie.name", target = "movieName")
    AvaliationGetResponse toAvaliationGetResponse(Avaliation avaliation);
    
    List<AvaliationGetResponse> toAvaliationGetResponseList(List<Avaliation> avaliations);
}
