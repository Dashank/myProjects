package com.example.NewsFeed.dtos;
import com.example.NewsFeed.models.User;

public class SignUpResDTO extends ResponseDTO {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
