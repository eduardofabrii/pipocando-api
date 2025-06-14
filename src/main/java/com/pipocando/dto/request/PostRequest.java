package com.pipocando.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Integer userId;
    
    private Integer movieId;
    private Integer serieId;
}
