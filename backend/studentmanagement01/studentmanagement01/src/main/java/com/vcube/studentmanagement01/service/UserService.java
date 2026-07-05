package com.vcube.studentmanagement01.service;

import java.util.Optional;

import com.vcube.studentmanagement01.entity.User;


public interface UserService {

    User registerUser(User user);

    Optional<User> login(String email, String password);

}