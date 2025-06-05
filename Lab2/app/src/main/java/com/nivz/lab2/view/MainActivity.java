package com.nivz.lab2.view;

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
import com.nivz.lab2.presenter.RandomPresenter;

public class MainActivity extends AppCompatActivity implements RandomView {
    private EditText edtMin, edtMax;
    private TextView txtResult;
    private RandomPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtMin = findViewById(R.id.etMin);
        edtMax = findViewById(R.id.etMax);
        txtResult = findViewById(R.id.tvResult);
        Button btnGenerate = findViewById(R.id.btnGenerate);

        presenter = new RandomPresenter(this);

        btnGenerate.setOnClickListener(v -> presenter.onGenerateClicked());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void showResult(String result) {
        txtResult.setText("Result: " + result);
    }

    @Override
    public int getMin() {
        return Integer.parseInt(edtMin.getText().toString());
    }

    @Override
    public int getMax() {
        return Integer.parseInt(edtMax.getText().toString());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}