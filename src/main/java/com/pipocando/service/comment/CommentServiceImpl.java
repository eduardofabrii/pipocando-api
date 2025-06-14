package com.pipocando.service.comment;

import com.pipocando.domain.blog.Comment;
import com.pipocando.dto.request.CommentRequest;
import com.pipocando.dto.response.CommentResponse;
import com.pipocando.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public CommentResponse addComment(Integer postId, CommentRequest commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setUserId(commentDTO.getUserId());
        comment.setPostId(postId);
        comment.setCreatedAt(LocalDateTime.now());
        Comment saved = commentRepository.save(comment);
        CommentResponse resp = new CommentResponse();
        resp.setId(saved.getId());
        resp.setContent(saved.getContent());
        resp.setUserId(saved.getUserId());
        resp.setPostId(saved.getPostId());
        return resp;
    }

    @Override
    public List<CommentResponse> getComments(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResponse> resp = new ArrayList<>();
        for (Comment c : comments) {
            CommentResponse cr = new CommentResponse();
            cr.setId(c.getId());
            cr.setContent(c.getContent());
            cr.setUserId(c.getUserId());
            cr.setPostId(c.getPostId());
            resp.add(cr);
        }
        return resp;
    }
}
