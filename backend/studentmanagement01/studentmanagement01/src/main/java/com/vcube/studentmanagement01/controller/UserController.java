package com.vcube.studentmanagement01.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

import com.vcube.studentmanagement01.entity.User;
import com.vcube.studentmanagement01.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> loginUser =
                userService.login(user.getEmail(), user.getPassword());

        if (loginUser.isPresent()) {
            return "Login Successful";
        } else {
            return "Invalid Email or Password";
        }
    }
}