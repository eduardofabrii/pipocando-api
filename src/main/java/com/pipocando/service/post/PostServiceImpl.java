package com.pipocando.service.post;

import com.pipocando.domain.blog.Post;
import com.pipocando.dto.response.PostResponse;
import com.pipocando.mapper.PostMapper;
import com.pipocando.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return null;
    }

    @Override
    public PostResponse createPost(PostResponse postDTO) {
        return null;
    }

    @Override
    public PostResponse updatePost(Integer id, PostResponse postDTO) {
        return null;
    }
    
    @Override
    public void deletePost(Integer id) {
    }
}
