package com.pipocando.mapper;

import com.pipocando.domain.blog.Post;
import com.pipocando.domain.user.User;
import com.pipocando.dto.response.PostResponse;
import com.pipocando.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import com.pipocando.repository.UserRepository;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserRepository.class})
public abstract class PostMapper {
    @Autowired
    protected UserRepository userRepository;

    @Mapping(target = "author", source = "userId", qualifiedByName = "userIdToAuthor")
    @Mapping(target = "category", expression = "java(resolveCategory(post))")
    public abstract PostResponse toResponse(Post post);

    public abstract List<PostResponse> toResponseList(List<Post> posts);

    @Named("userIdToAuthor")
    protected AuthorResponse userIdToAuthor(Integer userId) {
        if (userId == null) return null;
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return null;
        AuthorResponse author = new AuthorResponse();
        author.setId(user.getId());
        author.setName(user.getName());
        author.setEmail(user.getEmail());
        return author;
    }

    protected String resolveCategory(Post post) {
        if (post.getSerieId() != null) return "Séries";
        if (post.getMovieId() != null) return "Filmes";
        return "Blog";
    }
}
