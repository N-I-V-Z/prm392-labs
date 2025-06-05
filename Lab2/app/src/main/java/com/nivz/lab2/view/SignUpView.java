package com.nivz.lab2.view;

public interface SignUpView {
    String getUsername();
    String getPassword();
    String getConfirmPassword();
    void showRegisterSuccess();
    void showRegisterError(String message);
}
