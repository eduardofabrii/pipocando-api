package com.pipocando.service.blog.impl;

import com.pipocando.dto.comment.CommentDTO;
import com.pipocando.dto.comment.CommentResponseDTO;
import com.pipocando.service.blog.CommentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentResponseDTO addComment(Integer postId, CommentDTO commentDTO) {
        return null;
    }
    @Override
    public List<CommentResponseDTO> getComments(Integer postId) {
        return new ArrayList<>();
    }
}
