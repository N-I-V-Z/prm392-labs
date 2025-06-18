package com.nivz.lab6_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mainViewLayout;
    private TextView textViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainViewLayout = findViewById(R.id.mainViewLayout);
        textViewMenu = findViewById(R.id.textViewMenu);

        // Đăng ký Context Menu cho TextView
        registerForContextMenu(textViewMenu);
    }

    // Tạo Context Menu khi long click
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Xử lý khi chọn item trong Context Menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_set_redcolor) {
            Toast.makeText(this, "Chọn Red", Toast.LENGTH_SHORT).show();
            mainViewLayout.setBackgroundColor(Color.RED);
            return true;
        } else if (id == R.id.action_set_greencolor) {
            Toast.makeText(this, "Chọn Green", Toast.LENGTH_SHORT).show();
            mainViewLayout.setBackgroundColor(Color.GREEN);
            return true;
        } else if (id == R.id.action_set_bluecolor) {
            Toast.makeText(this, "Chọn Blue", Toast.LENGTH_SHORT).show();
            mainViewLayout.setBackgroundColor(Color.BLUE);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}