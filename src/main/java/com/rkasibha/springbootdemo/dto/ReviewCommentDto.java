package com.rkasibha.springbootdemo.dto;

public class ReviewCommentDto {

    private Integer id;

    private String commentText;

    public ReviewCommentDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
