package com.pipocando.dto.response;

import java.util.List;

public record MovieGetResponse(
    Integer id,
    String name,
    List<String> streamingPlatforms,
    String company,
    String director,
    List<String> actors,
    Integer durationMinutes
) {}
