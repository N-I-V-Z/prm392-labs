package com.example.lab5_1.presenter;

import com.example.lab5_1.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter {
    private List<User> users = new ArrayList<>();

    public UserPresenter() {
        // Dummy data
        users.add(new User("nhan01", "Nhàn Trần", "nhan@example.com"));
        users.add(new User("nga02", "Nga Nguyễn", "nga@example.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(int position, User user) {
        users.set(position, user);
    }

    public void deleteUser(int position) {
        users.remove(position);
    }
}

