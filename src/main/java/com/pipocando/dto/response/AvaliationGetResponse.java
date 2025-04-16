package com.pipocando.dto.response;

public record AvaliationGetResponse(
    Integer id,
    Integer rating,
    String comment,
    Integer userId,
    String userName,
    Integer movieId,
    String movieName
) {}
