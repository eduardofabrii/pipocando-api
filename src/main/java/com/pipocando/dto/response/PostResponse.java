package com.pipocando.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Integer id;
    private String title;
    private String content;
    private AuthorResponse author;
    private String category;
    private LocalDateTime createdAt;
}
