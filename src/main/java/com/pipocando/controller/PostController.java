package com.pipocando.controller;

import com.pipocando.dto.request.CommentRequest;
import com.pipocando.dto.request.PostEvaluationRequest;
import com.pipocando.dto.request.PostRequest;
import com.pipocando.dto.response.CommentResponse;
import com.pipocando.dto.response.PostEvaluationResponse;
import com.pipocando.dto.response.PostResponse;
import com.pipocando.service.comment.CommentService;
import com.pipocando.service.post.PostService;
import com.pipocando.service.postevaluation.PostEvaluationService;

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
    public ResponseEntity<List<PostResponse>> getAllPosts(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer movieId,
            @RequestParam(required = false) Integer serieId) {
        if (title != null || userId != null || movieId != null || serieId != null) {
            return ResponseEntity.ok(postService.searchPosts(title, userId, movieId, serieId));
        }
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Integer id, @RequestBody PostRequest postDTO) {
        return ResponseEntity.ok(postService.updatePost(id, postDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    // Comentários
    @PostMapping("/{postId}/comment")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Integer postId, @RequestBody CommentRequest commentDTO) {
        return ResponseEntity.ok(commentService.addComment(postId, commentDTO));
    }

    @GetMapping("/{postId}/comment")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Integer postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    // Avaliações
    @PostMapping("/{postId}/evaluation")
    public ResponseEntity<PostEvaluationResponse> addEvaluation(@PathVariable Integer postId, @RequestBody PostEvaluationRequest evaluationDTO) {
        return ResponseEntity.ok(postEvaluationService.addEvaluation(postId, evaluationDTO));
    }

    @GetMapping("/{postId}/evaluation")
    public ResponseEntity<List<PostEvaluationResponse>> getEvaluations(@PathVariable Integer postId) {
        return ResponseEntity.ok(postEvaluationService.getEvaluations(postId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostResponse>> searchPostsAdvanced(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String movieName,
            @RequestParam(required = false) String serieName,
            @RequestParam(required = false, defaultValue = "all") String category) {
                return ResponseEntity.ok(postService.searchPostsAdvancedWithCategory(title, userName, movieName, serieName, category));
    }
}
