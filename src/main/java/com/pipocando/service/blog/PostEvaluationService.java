package com.pipocando.service.blog;

import com.pipocando.dto.evaluation.PostEvaluationDTO;
import com.pipocando.dto.evaluation.PostEvaluationResponseDTO;
import java.util.List;

public interface PostEvaluationService {
    PostEvaluationResponseDTO addEvaluation(Integer postId, PostEvaluationDTO evaluationDTO);
    List<PostEvaluationResponseDTO> getEvaluations(Integer postId);
}
