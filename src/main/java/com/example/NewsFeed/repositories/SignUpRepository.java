package com.example.NewsFeed.repositories;
import com.example.NewsFeed.models.User;
import java.util.List;

import java.util.ArrayList;

public class SignUpRepository {

    private static List<User> users = new ArrayList<>();
    private static Long nextId = 0L;

    public static User save(User user) {

        user.setId(nextId);
        nextId += 1;
        users.add(user);

        return user;
    }

    public static Boolean alreadyExists(User user) {

        int size = users.size();

        for(int i=0;i<size;i++) {
            User savedUser = users.get(i);

            if(user.getUsername().equals(savedUser.getUsername()) &&
                user.getPassword().equals(savedUser.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static void setSession(User user) {
        int size = users.size();

        for(int i=0;i<size;i++) {
            User savedUser = users.get(i);

            if(user.getUsername().equals(savedUser.getUsername()) &&
                    user.getPassword().equals(savedUser.getPassword())) {
                savedUser.setSession(true);
                return ;
            }
        }
    }

}
