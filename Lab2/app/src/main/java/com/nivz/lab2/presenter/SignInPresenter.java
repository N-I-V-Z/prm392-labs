package com.nivz.lab2.presenter;

import com.nivz.lab2.model.UserModel;
import com.nivz.lab2.view.SignInView;

public class SignInPresenter {
    private final SignInView view;
    private final UserModel model;

    public SignInPresenter(SignInView view) {
        this.view = view;
        this.model = new UserModel();
    }

    public void handleLogin() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (!model.isValidUser(username, password)) {
            view.showLoginError("Không được để trống");
        } else {
            view.showLoginSuccess();
        }
    }
}
