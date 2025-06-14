package com.pipocando.service.blog.impl;

import com.pipocando.dto.post.PostDTO;
import com.pipocando.dto.post.PostResponseDTO;
import com.pipocando.service.blog.PostService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<PostResponseDTO> getAllPosts() {
        return new ArrayList<>();
    }
    @Override
    public PostResponseDTO getPostById(Integer id) {
        return null;
    }
    @Override
    public PostResponseDTO createPost(PostDTO postDTO) {
        return null;
    }
    @Override
    public PostResponseDTO updatePost(Integer id, PostDTO postDTO) {
        return null;
    }
    @Override
    public void deletePost(Integer id) {
    }
}
