package com.pipocando.dto.response;

import lombok.Data;

@Data
public class PostEvaluationResponse {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private Integer rating;
}
