package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.CreateReviewRequest;
import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.pojo.entity.Review;
import com.notimdb.notimdb.pojo.entity.User;
import com.notimdb.notimdb.repository.MovieRepository;
import com.notimdb.notimdb.repository.ReviewRepository;
import com.notimdb.notimdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }
    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Integer id){
        return reviewRepository.findById(id).orElse(null);
    }

    @PostMapping("/reviews")
    public Review createReview(@RequestBody CreateReviewRequest newReview) {
        Review review = new Review();
        review.setRating(newReview.getRating());
        review.setComment(newReview.getComment());
        User user = userRepository.findById(newReview.getUserId()).orElse(null);
        review.setUser(user);
        Movie movie = movieRepository.findById(newReview.getMovieId()).orElse(null);
        review.setMovie(movie);

        return reviewRepository.save(review);
    }
}
