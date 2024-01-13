package com.notimdb.notimdb.service;

import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.pojo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User addUser(User user);

    void deleteUser(Integer id);

   // User updateUser(Integer id, UserUpdateRequest request);
}
