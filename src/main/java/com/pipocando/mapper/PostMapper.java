package com.pipocando.mapper;

import com.pipocando.domain.blog.Post;
import com.pipocando.dto.response.PostResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    public PostResponse toResponse(Post post) {
        if (post == null) return null;
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setUserId(post.getUserId());
        response.setMovieId(post.getMovieId());
        response.setSerieId(post.getSerieId());
        return response;
    }

    public List<PostResponse> toResponseList(List<Post> posts) {
        return posts.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
