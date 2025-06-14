package com.pipocando.service.postevaluation;

import com.pipocando.dto.request.PostEvaluationRequest;
import com.pipocando.dto.response.PostEvaluationResponse;

import java.util.List;

public interface PostEvaluationService {
    PostEvaluationResponse addEvaluation(Integer postId, PostEvaluationRequest evaluationDTO);
    List<PostEvaluationResponse> getEvaluations(Integer postId);
}
