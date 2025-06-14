package com.pipocando.service.comment;

import com.pipocando.dto.request.CommentRequest;
import com.pipocando.dto.response.CommentResponse;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentResponse addComment(Integer postId, CommentRequest commentDTO) {
        return null;
    }
    
    @Override
    public List<CommentResponse> getComments(Integer postId) {
        return new ArrayList<>();
    }
}
