package com.pipocando.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuthorResponse {
    private Integer id;
    private String name;
    private String email;
}
