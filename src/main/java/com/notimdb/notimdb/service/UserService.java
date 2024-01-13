package com.notimdb.notimdb.service;

import com.notimdb.notimdb.pojo.dto.CreateReviewFromUser;
import com.notimdb.notimdb.pojo.dto.CreateReviewRequest;
import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.pojo.entity.Review;
import com.notimdb.notimdb.pojo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User addUser(User user);
    Movie addMovieReview(Integer id, CreateReviewFromUser newReview);

    void deleteUser(Integer id);

   // User updateUser(Integer id, UserUpdateRequest request);
}
