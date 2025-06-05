package com.nivz.lab2.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nivz.lab2.R;
import com.nivz.lab2.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private EditText etSo1, etSo2;
    private TextView tvResult;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etSo1 = findViewById(R.id.etSo1);
        etSo2 = findViewById(R.id.etSo2);
        tvResult = findViewById(R.id.tvResult);

        presenter = new CalculatorPresenter(this);

        findViewById(R.id.btnAdd).setOnClickListener(v -> presenter.onAddClicked());
        findViewById(R.id.btnSub).setOnClickListener(v -> presenter.onSubClicked());
        findViewById(R.id.btnMul).setOnClickListener(v -> presenter.onMulClicked());
        findViewById(R.id.btnDiv).setOnClickListener(v -> presenter.onDivClicked());
    }

    @Override
    public double getSo1() {
        return Double.parseDouble(etSo1.getText().toString());
    }

    @Override
    public double getSo2() {
        return Double.parseDouble(etSo2.getText().toString());
    }

    @Override
    public void showResult(String result) {
        tvResult.setText("Kết quả: " + result);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}