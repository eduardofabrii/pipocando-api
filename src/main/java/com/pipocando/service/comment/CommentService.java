package com.pipocando.service.comment;

import com.pipocando.dto.request.CommentRequest;
import com.pipocando.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse addComment(Integer postId, CommentRequest commentDTO);
    List<CommentResponse> getComments(Integer postId);
}
