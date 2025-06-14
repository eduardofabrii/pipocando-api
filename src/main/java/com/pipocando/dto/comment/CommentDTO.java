package com.pipocando.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDTO {
    @NotBlank
    private String content;

    @NotNull
    private Integer userId;
}
