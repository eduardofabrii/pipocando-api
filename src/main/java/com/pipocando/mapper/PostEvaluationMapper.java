package com.pipocando.mapper;

import com.pipocando.domain.blog.PostEvaluation;
import com.pipocando.dto.response.PostEvaluationResponse;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostEvaluationMapper {
    PostEvaluationResponse toResponse(PostEvaluation pe);

    List<PostEvaluationResponse> toResponseList(List<PostEvaluation> list);
}
