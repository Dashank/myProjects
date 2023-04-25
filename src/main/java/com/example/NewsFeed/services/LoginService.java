package com.example.NewsFeed.services;
import com.example.NewsFeed.models.User;
import com.example.NewsFeed.repositories.SignUpRepository;

public class LoginService {

    private SignUpRepository signUpRepository;

    public LoginService(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    public User createLoginService(String username,String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(String.valueOf(password.hashCode()));

        Boolean valid = SignUpRepository.alreadyExists(user);
        if(valid) {
            SignUpRepository.setSession(user);
            return user;
        }
        else {
            return null;
        }


    }
}
