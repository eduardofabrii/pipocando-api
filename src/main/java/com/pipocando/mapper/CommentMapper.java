package com.pipocando.mapper;

import com.pipocando.domain.blog.Comment;
import com.pipocando.dto.response.CommentResponse;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    CommentResponse toResponse(Comment comment);

    List<CommentResponse> toResponseList(List<Comment> comments);
}
