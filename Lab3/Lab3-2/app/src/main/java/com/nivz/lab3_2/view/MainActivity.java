package com.nivz.lab3_2.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nivz.lab3_2.R;
import com.nivz.lab3_2.adapter.FruitAdapter;
import com.nivz.lab3_2.model.Fruit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FruitAdapter adapter;
    private ArrayList<Fruit> fruitList;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnClose = findViewById(R.id.btnClose);

        // Dữ liệu ban đầu
        fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Chuối tiêu", "Chuối tiêu Long An", R.drawable.chuoitieu));
        fruitList.add(new Fruit("Thanh Long", "Thanh long ruột đỏ", R.drawable.thanhlong));
        fruitList.add(new Fruit("Dâu tây", "Dâu tây Đà Lạt", R.drawable.dautay));

        adapter = new FruitAdapter(this, fruitList);
        listView.setAdapter(adapter);

        // Chọn item trong ListView
        listView.setOnItemClickListener((parent, view, position, id) -> selectedPosition = position);

        // Thêm item mới
        btnAdd.setOnClickListener(v -> {
            fruitList.add(new Fruit("Cam vàng", "Cam Vàng Cái Bè", R.drawable.camvang));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã thêm Cam Vàng", Toast.LENGTH_SHORT).show();
        });

        // Sửa item
        btnEdit.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                Fruit fruit = fruitList.get(selectedPosition);
                fruit.setName(fruit.getName() + " (Updated)");
                fruit.setDescription("Đã cập nhật mô tả");
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Đã cập nhật " + fruit.getName(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng chọn item để sửa", Toast.LENGTH_SHORT).show();
            }
        });

        // Xóa item
        btnDelete.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                new AlertDialog.Builder(this)
                        .setTitle("Xóa Item")
                        .setMessage("Bạn có chắc muốn xóa " + fruitList.get(selectedPosition).getName() + " không?")
                        .setPositiveButton("Xóa", (dialog, which) -> {
                            fruitList.remove(selectedPosition);
                            adapter.notifyDataSetChanged();
                            selectedPosition = -1; // Reset vị trí
                            Toast.makeText(this, "Đã xóa item", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Hủy", null)
                        .show();
            } else {
                Toast.makeText(this, "Vui lòng chọn item để xóa", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện nút Đóng
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}