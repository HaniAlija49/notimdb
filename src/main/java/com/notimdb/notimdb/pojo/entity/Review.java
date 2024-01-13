package com.notimdb.notimdb.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties("reviews")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reviews")
    private User user;

    public Review() {
    }

    public Review(Integer id, Double rating, String comment, Movie movie) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
