package com.pipocando.dto.response;

public record SerieGetResponse(
    Integer id,
    String name,
    String streaming,
    String company,
    String director,
    String actors,
    Integer seasons
) {}
