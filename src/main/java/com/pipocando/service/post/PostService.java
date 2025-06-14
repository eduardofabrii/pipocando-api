package com.pipocando.service.post;

import java.util.List;

import com.pipocando.dto.response.PostResponse;

public interface PostService {
    List<PostResponse> getAllPosts();
    PostResponse getPostById(Integer id);
    PostResponse createPost(PostResponse postDTO);
    PostResponse updatePost(Integer id, PostResponse postDTO);
    void deletePost(Integer id);
}
