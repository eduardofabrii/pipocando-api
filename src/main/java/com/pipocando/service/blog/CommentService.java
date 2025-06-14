package com.pipocando.service.blog;

import com.pipocando.dto.comment.CommentDTO;
import com.pipocando.dto.comment.CommentResponseDTO;
import java.util.List;

public interface CommentService {
    CommentResponseDTO addComment(Integer postId, CommentDTO commentDTO);
    List<CommentResponseDTO> getComments(Integer postId);
}
