package com.pipocando.service.comment;

import com.pipocando.domain.blog.Comment;
import com.pipocando.dto.request.CommentRequest;
import com.pipocando.dto.response.CommentResponse;
import com.pipocando.repository.CommentRepository;
import com.pipocando.mapper.CommentMapper;
import com.pipocando.repository.UserRepository;

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

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CommentResponse addComment(Integer postId, CommentRequest commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setUserId(commentDTO.getUserId());
        comment.setPostId(postId);
        comment.setCreatedAt(LocalDateTime.now());
        Comment saved = commentRepository.save(comment);
        CommentResponse resp = commentMapper.toResponse(saved);
        userRepository.findById(saved.getUserId()).ifPresent(user -> resp.setUserName(user.getName()));
        return resp;
    }

    @Override
    public List<CommentResponse> getComments(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResponse> resp = new ArrayList<>();
        for (Comment c : comments) {
            CommentResponse cr = commentMapper.toResponse(c);
            userRepository.findById(c.getUserId()).ifPresent(user -> cr.setUserName(user.getName()));
            resp.add(cr);
        }
        return resp;
    }

    @Override
    @Transactional
    public CommentResponse updateComment(Integer commentId, CommentRequest commentDTO) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
        comment.setContent(commentDTO.getContent());
        commentRepository.save(comment);
        return commentMapper.toResponse(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
