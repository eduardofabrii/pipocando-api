package com.pipocando.dto.evaluation;

import lombok.Data;

@Data
public class PostEvaluationResponseDTO {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private Integer rating;
}
