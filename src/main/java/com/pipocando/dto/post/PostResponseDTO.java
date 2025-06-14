package com.pipocando.dto.post;

public class PostResponseDTO {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer movieId;
    private Integer serieId;
    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }
    public Integer getSerieId() { return serieId; }
    public void setSerieId(Integer serieId) { this.serieId = serieId; }
}
