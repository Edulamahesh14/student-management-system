package com.vcube.studentmanagement01.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vcube.studentmanagement01.entity.User;
import com.vcube.studentmanagement01.repository.UserRepository;
import com.vcube.studentmanagement01.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}