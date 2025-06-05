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
import com.nivz.lab2.presenter.SignInPresenter;

public class SignInActivity extends AppCompatActivity implements SignInView {
    private EditText etUsername, etPassword;
    private SignInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnSignIn);
        TextView tvCreate = findViewById(R.id.tvCreateOne);

        presenter = new SignInPresenter(this);

        btnLogin.setOnClickListener(v -> presenter.handleLogin());

        tvCreate.setOnClickListener(v -> startActivity(new Intent(this, SignUpActivity.class)));

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
    public void showLoginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}