package com.nivz.lab2.presenter;

import android.content.Context;

import com.nivz.lab2.model.UserModel;
import com.nivz.lab2.view.SignUpView;

public class SignUpPresenter {
    private final SignUpView view;
    private final UserModel model;

    public SignUpPresenter(SignUpView view) {
        this.view = view;
        this.model = new UserModel();
    }

    public void handleRegister() {
        String username = view.getUsername();
        String password = view.getPassword();
        String confirm = view.getConfirmPassword();

        if (!model.isValidUser(username, password) || confirm.isEmpty()) {
            view.showRegisterError("Không được để trống");
        } else if (!model.checkPassword(password, confirm)) {
            view.showRegisterError("Password không khớp");
        }  else {
            view.showRegisterSuccess();
        }
    }
}
