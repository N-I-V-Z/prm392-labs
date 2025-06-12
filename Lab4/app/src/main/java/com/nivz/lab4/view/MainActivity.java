package com.nivz.lab4.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nivz.lab4.R;
import com.nivz.lab4.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {
    private TextView tvFood, tvDrink;
    private Button btnFood, btnDrink;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvFood = findViewById(R.id.tv_food_selection);
        tvDrink = findViewById(R.id.tv_drink_selection);
        btnFood = findViewById(R.id.btn_choose_food);
        btnDrink = findViewById(R.id.btn_choose_drink);

        presenter = new MainPresenter(this);

        btnFood.setOnClickListener(v -> presenter.onFoodButtonClicked());
        btnDrink.setOnClickListener(v -> presenter.onDrinkButtonClicked());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.handleActivityResult(requestCode, resultCode, data, this);
    }

    @Override
    public void onFoodSelected(String name, int price) {
        tvFood.setText(name + " - " + price + " VND");
    }

    @Override
    public void onDrinkSelected(String name, int price) {
        tvDrink.setText(name + " - " + price + " VND");
    }
}