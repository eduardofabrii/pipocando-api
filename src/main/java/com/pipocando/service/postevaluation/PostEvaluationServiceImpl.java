package com.pipocando.service.postevaluation;


import com.pipocando.domain.blog.PostEvaluation;
import com.pipocando.dto.request.PostEvaluationRequest;
import com.pipocando.dto.response.PostEvaluationResponse;
import com.pipocando.repository.PostEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostEvaluationServiceImpl implements PostEvaluationService {
    @Autowired
    private PostEvaluationRepository postEvaluationRepository;
    
    @Override
    @Transactional
    public PostEvaluationResponse addEvaluation(Integer postId, PostEvaluationRequest evaluationDTO) {
        PostEvaluation pe = new PostEvaluation();
        pe.setUserId(evaluationDTO.getUserId());
        pe.setPostId(postId);
        pe.setRating(evaluationDTO.getRating());
        PostEvaluation saved = postEvaluationRepository.save(pe);
        PostEvaluationResponse resp = new PostEvaluationResponse();
        resp.setId(saved.getId());
        resp.setUserId(saved.getUserId());
        resp.setPostId(saved.getPostId());
        resp.setRating(saved.getRating());
        return resp;
    }
    
    @Override
    public List<PostEvaluationResponse> getEvaluations(Integer postId) {
        List<PostEvaluation> list = postEvaluationRepository.findByPostId(postId);
        List<PostEvaluationResponse> resp = new java.util.ArrayList<>();
        for (PostEvaluation pe : list) {
            PostEvaluationResponse r = new PostEvaluationResponse();
            r.setId(pe.getId());
            r.setUserId(pe.getUserId());
            r.setPostId(pe.getPostId());
            r.setRating(pe.getRating());
            resp.add(r);
        }
        return resp;
    }
}
