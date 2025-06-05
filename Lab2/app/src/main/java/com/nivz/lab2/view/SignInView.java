package com.nivz.lab2.view;

public interface SignInView {
    String getUsername();
    String getPassword();
    void showLoginSuccess();
    void showLoginError(String message);
}
