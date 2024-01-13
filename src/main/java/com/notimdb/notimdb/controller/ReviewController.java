package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.CreateReviewRequest;
import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.pojo.entity.Review;
import com.notimdb.notimdb.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

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

        return reviewRepository.save(review);
    }
}
