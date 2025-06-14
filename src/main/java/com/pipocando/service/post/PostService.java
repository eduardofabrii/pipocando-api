package com.pipocando.service.post;

import java.util.List;

import com.pipocando.dto.response.PostResponse;
import com.pipocando.dto.request.PostRequest;

public interface PostService {
    List<PostResponse> getAllPosts();
    PostResponse getPostById(Integer id);
    PostResponse createPost(PostRequest postDTO);
    PostResponse updatePost(Integer id, PostRequest postDTO);
    void deletePost(Integer id);
    List<PostResponse> searchPosts(String title, Integer userId, Integer movieId, Integer serieId);
    List<PostResponse> searchPostsAdvanced(String title, String userName, String movieName, String serieName);
    List<PostResponse> searchPostsAdvancedWithCategory(String title, String userName, String movieName, String serieName, String category);
}
