package com.notimdb.notimdb.pojo.dto;

public class CreateReviewRequest {
    private Double rating;

    private String comment;
    private Integer movieId;
    private Integer userId;

    public CreateReviewRequest() {
    }

    public CreateReviewRequest(Double rating, String comment, Integer movieId, Integer userId) {
        this.rating = rating;
        this.comment = comment;
        this.movieId = movieId;
        this.userId = userId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
