package com.pipocando.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.pipocando.domain.user.User;
import com.pipocando.dto.response.UserGetResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    List<UserGetResponse> toUserGetResponseList(List<User> users);
    
    UserGetResponse toUserGetResponse(User user);
}