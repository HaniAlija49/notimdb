package com.notimdb.notimdb.service;

import com.notimdb.notimdb.MovieNotFoundException;
import com.notimdb.notimdb.UserNotFountException;
import com.notimdb.notimdb.pojo.dto.CreateReviewFromUser;
import com.notimdb.notimdb.pojo.dto.CreateReviewRequest;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.pojo.entity.Review;
import com.notimdb.notimdb.pojo.entity.User;
import com.notimdb.notimdb.repository.MovieRepository;
import com.notimdb.notimdb.repository.ReviewRepository;
import com.notimdb.notimdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Movie addMovieReview(Integer id, CreateReviewFromUser newReview) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found"));

        Set<Review> reviewsWithMovieId = new HashSet<>();
        Iterable<Review> allReviews = reviewRepository.findAll();
        Double averageRating = 0.0;
        for (Review r : allReviews) {
            if (r.getMovie().getId().equals(movie.getId())) {
                averageRating += r.getRating();
                reviewsWithMovieId.add(r);
            }
        }

        User user = userRepository.findById(newReview.getUserId())
                .orElseThrow(() -> new UserNotFountException("User with ID " + newReview.getUserId() + " not found"));

        Review review = new Review();
        review.setRating(newReview.getRating());
        review.setComment(newReview.getComment());
        review.setMovie(movie);
        review.setUser(user);

        reviewsWithMovieId.add(review);

        averageRating += review.getRating();
        averageRating /= reviewsWithMovieId.size();
        averageRating = Math.round(averageRating * 10.0) / 10.0;

        movie.setRating(averageRating);
        movie.setReviews(reviewsWithMovieId);

        reviewRepository.save(review);

        return movie;
    }



    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
