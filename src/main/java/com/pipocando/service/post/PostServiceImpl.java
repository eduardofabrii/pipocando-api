package com.pipocando.service.post;

import com.pipocando.domain.blog.Post;
import com.pipocando.dto.response.PostResponse;
import com.pipocando.mapper.PostMapper;
import com.pipocando.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postMapper.toResponseList(posts);
    }

    @Override
    public PostResponse getPostById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        return postMapper.toResponse(post);
    }

    @Override
    @Transactional
    public PostResponse createPost(PostResponse postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setUserId(postDTO.getUserId());
        post.setMovieId(postDTO.getMovieId());
        post.setSerieId(postDTO.getSerieId());
        post.setCreatedAt(java.time.LocalDateTime.now());
        post.setUpdatedAt(java.time.LocalDateTime.now());
        Post saved = postRepository.save(post);
        return postMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public PostResponse updatePost(Integer id, PostResponse postDTO) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) return null;
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setUserId(postDTO.getUserId());
        post.setMovieId(postDTO.getMovieId());
        post.setSerieId(postDTO.getSerieId());
        post.setUpdatedAt(java.time.LocalDateTime.now());
        Post updated = postRepository.save(post);
        return postMapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
