package com.nivz.lab5_2.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.nivz.lab5_2.R;
import com.nivz.lab5_2.model.Product;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgDetail;
    private TextView tvDetailName, tvDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            tvDetailName.setText(product.getName());
            tvDetailDescription.setText(product.getDescription());
            imgDetail.setImageResource(product.getImageResId());
        }

    }
}