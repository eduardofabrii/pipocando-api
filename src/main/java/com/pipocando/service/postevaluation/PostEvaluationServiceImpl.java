package com.pipocando.service.postevaluation;


import com.pipocando.dto.request.PostEvaluationRequest;
import com.pipocando.dto.response.PostEvaluationResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostEvaluationServiceImpl implements PostEvaluationService {
    @Override
    public PostEvaluationResponse addEvaluation(Integer postId, PostEvaluationRequest evaluationDTO) {
        return null;
    }
    
    @Override
    public List<PostEvaluationResponse> getEvaluations(Integer postId) {
        return new ArrayList<>();
    }
}
