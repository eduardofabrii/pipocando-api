package com.pipocando.controller;

import com.pipocando.dto.post.PostDTO;
import com.pipocando.dto.post.PostResponseDTO;
import com.pipocando.dto.comment.CommentDTO;
import com.pipocando.dto.comment.CommentResponseDTO;
import com.pipocando.dto.evaluation.PostEvaluationDTO;
import com.pipocando.dto.evaluation.PostEvaluationResponseDTO;
import com.pipocando.service.blog.PostService;
import com.pipocando.service.blog.CommentService;
import com.pipocando.service.blog.PostEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostEvaluationService postEvaluationService;

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Integer id, @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.updatePost(id, postDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    // Comentários
    @PostMapping("/{postId}/comment")
    public ResponseEntity<CommentResponseDTO> addComment(@PathVariable Integer postId, @RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.addComment(postId, commentDTO));
    }

    @GetMapping("/{postId}/comment")
    public ResponseEntity<List<CommentResponseDTO>> getComments(@PathVariable Integer postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    // Avaliações
    @PostMapping("/{postId}/evaluation")
    public ResponseEntity<PostEvaluationResponseDTO> addEvaluation(@PathVariable Integer postId, @RequestBody PostEvaluationDTO evaluationDTO) {
        return ResponseEntity.ok(postEvaluationService.addEvaluation(postId, evaluationDTO));
    }

    @GetMapping("/{postId}/evaluation")
    public ResponseEntity<List<PostEvaluationResponseDTO>> getEvaluations(@PathVariable Integer postId) {
        return ResponseEntity.ok(postEvaluationService.getEvaluations(postId));
    }
}
