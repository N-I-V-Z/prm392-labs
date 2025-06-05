package com.nivz.lab2.model;

import android.content.Context;
import android.text.TextUtils;

public class UserModel {
    public boolean isValidUser(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    public boolean checkPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}
