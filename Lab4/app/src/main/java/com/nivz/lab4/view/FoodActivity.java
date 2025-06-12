package com.nivz.lab4.view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nivz.lab4.R;
import com.nivz.lab4.model.MenuItem;
import com.nivz.lab4.presenter.FoodPresenter;
import com.nivz.lab4.view.adapter.MenuAdapter;

import java.util.List;

public class FoodActivity extends AppCompatActivity implements FoodPresenter.FoodView {
    private ListView listView;
    private FoodPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listView = findViewById(R.id.lv_food);
        presenter = new FoodPresenter(this, this);
        presenter.loadMenu();
        listView.setOnItemClickListener((parent, view, position, id) -> presenter.onItemSelected(position));
    }

    @Override
    public void displayMenu(List<MenuItem> items) {
        MenuAdapter adapter = new MenuAdapter(this, R.layout.item_menu, items);
        listView.setAdapter(adapter);
    }
}
