package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.entity.Director;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public List<Director> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }
    @GetMapping("/reviews/{id}")
    public Director getReviewById(@PathVariable Integer id){
        return reviewRepository.findById(id).orElse(null);
    }

    @PostMapping("/reviews")
    public Director createReview(@RequestBody Review newReview) {
        Review review = new Review();
        review.setRating(newReview.getRating());
        review.setComment(newReview.gerComment());

        return reviewRepository.save(review);
    }
}
