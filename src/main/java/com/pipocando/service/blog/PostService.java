package com.pipocando.service.blog;

import com.pipocando.dto.post.PostDTO;
import com.pipocando.dto.post.PostResponseDTO;
import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllPosts();
    PostResponseDTO getPostById(Integer id);
    PostResponseDTO createPost(PostDTO postDTO);
    PostResponseDTO updatePost(Integer id, PostDTO postDTO);
    void deletePost(Integer id);
}
