package com.example.NewsFeed.services;
import com.example.NewsFeed.models.User;
import com.example.NewsFeed.repositories.SignUpRepository;
import java.io.*;


public class SignUpService {

    private SignUpRepository signUpRepository;

    public SignUpService(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    public User createSignUpService(String username,String password) {

            User user = new User();
            user.setUsername(username);
            user.setPassword(String.valueOf(password.hashCode()));
            user.setSession(false);
            Boolean exist = SignUpRepository.alreadyExists(user);
            if(exist)
            {
                return null;
            }

            User savedUser = SignUpRepository.save(user);
            return savedUser;
    }
}
