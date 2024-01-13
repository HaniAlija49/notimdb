package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.CreateUserRequest;
import com.notimdb.notimdb.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest newUserRequest) {
        User user = new User();
        user.setUsername(newUserRequest.getUsername());
        user.setPassword(newUserRequest.getPassword()); // Note: In a real-world application, use secure password hashing

        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
