package com.nivz.lab3_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText edtItem;
    private Button btnAdd, btnUpdate, btnDelete;
    private ArrayList<String> programmingLanguages;
    private ArrayAdapter<String> adapter;
    private int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Tham chiếu tới ListView
        listView = findViewById(R.id.lvList);
        edtItem = findViewById(R.id.etInput);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        programmingLanguages = new ArrayList<>(Arrays.asList(
                "Java", "Python", "C++", "Kotlin", "Swift", "JavaScript", "PHP", "Ruby"
        ));

        // Sử dụng ArrayAdapter để hiển thị danh sách chuỗi
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, programmingLanguages);

        // Gán Adapter vào ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                selectedIndex = position;
                edtItem.setText(programmingLanguages.get(position));
            }
        });

        btnAdd.setOnClickListener(v -> {
            String newItem = edtItem.getText().toString().trim();
            if (!newItem.isEmpty()) {
                programmingLanguages.add(newItem);
                adapter.notifyDataSetChanged();
                edtItem.setText("");
            }
        });

        btnUpdate.setOnClickListener(v -> {
            String updatedItem = edtItem.getText().toString().trim();
            if (selectedIndex != -1 && !updatedItem.isEmpty()) {
                programmingLanguages.set(selectedIndex, updatedItem);
                adapter.notifyDataSetChanged();
                edtItem.setText("");
                selectedIndex = -1;
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                programmingLanguages.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                edtItem.setText("");
                selectedIndex = -1;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}