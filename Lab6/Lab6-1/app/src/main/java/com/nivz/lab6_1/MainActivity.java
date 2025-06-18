package com.nivz.lab6_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_recyclerview_1) {
            Toast.makeText(this, "Mở RecyclerView 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_listview_1) {
            Toast.makeText(this, "Mở ListView 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_listview_2) {
            Toast.makeText(this, "Mở ListView 2", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_listview_3) {
            Toast.makeText(this, "Mở ListView 3", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}