package com.nivz.lab5_2.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nivz.lab5_2.R;
import com.nivz.lab5_2.model.Product;
import com.nivz.lab5_2.view.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();
        productList.add(new Product("Pharmacy", "Mô tả sản phẩm Pharmacy", R.drawable.ic_pharmacy));
        productList.add(new Product("Cartwheel", "Mô tả sản phẩm Cartwheel", R.drawable.ic_cartwheel));
        productList.add(new Product("Clothing", "Mô tả sản phẩm Clothing", R.drawable.ic_clothing));
        productList.add(new Product("Shoes", "Mô tả sản phẩm Shoes", R.drawable.ic_shoes));
        productList.add(new Product("Accessories", "Mô tả sản phẩm Accessories", R.drawable.ic_accessories));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}