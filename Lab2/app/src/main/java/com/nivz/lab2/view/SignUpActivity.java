package com.nivz.lab2.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nivz.lab2.R;
import com.nivz.lab2.presenter.SignUpPresenter;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    private EditText etUsername, etPassword, etConfirm;
    private TextView tvSignIn;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirmPassword);
        Button btnRegister = findViewById(R.id.btnSignUn);
        tvSignIn = findViewById(R.id.tvSignIn);
        presenter = new SignUpPresenter(this);

        btnRegister.setOnClickListener(v -> presenter.handleRegister());
        tvSignIn.setOnClickListener(v -> startActivity(new Intent(this, SignInActivity.class)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public String getConfirmPassword() {
        return etConfirm.getText().toString();
    }

    @Override
    public void showRegisterSuccess() {
        Toast.makeText(this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showRegisterError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}