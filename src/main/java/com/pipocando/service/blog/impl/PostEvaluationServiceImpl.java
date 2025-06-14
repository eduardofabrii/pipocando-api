package com.pipocando.service.blog.impl;

import com.pipocando.dto.evaluation.PostEvaluationDTO;
import com.pipocando.dto.evaluation.PostEvaluationResponseDTO;
import com.pipocando.service.blog.PostEvaluationService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostEvaluationServiceImpl implements PostEvaluationService {
    @Override
    public PostEvaluationResponseDTO addEvaluation(Integer postId, PostEvaluationDTO evaluationDTO) {
        return null;
    }
    @Override
    public List<PostEvaluationResponseDTO> getEvaluations(Integer postId) {
        return new ArrayList<>();
    }
}
