package com.pipocando.dto.response;

public class CommentResponse {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer postId;
    private String userName;

    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getPostId() { return postId; }
    public void setPostId(Integer postId) { this.postId = postId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
