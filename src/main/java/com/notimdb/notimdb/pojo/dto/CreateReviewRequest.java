package com.notimdb.notimdb.pojo.dto;

public class CreateReviewRequest {
    private Double rating;

    private String comment;

    public CreateReviewRequest() {
    }

    public CreateReviewRequest(Double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
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
}
