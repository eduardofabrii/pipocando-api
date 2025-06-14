package com.pipocando.dto.response;

import lombok.Data;

@Data
public class PostResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer movieId;
    private Integer serieId;
}
