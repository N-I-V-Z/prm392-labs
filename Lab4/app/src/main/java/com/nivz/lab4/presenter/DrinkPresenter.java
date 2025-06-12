package com.nivz.lab4.presenter;

import android.content.Intent;

import com.nivz.lab4.R;
import com.nivz.lab4.model.MenuItem;
import com.nivz.lab4.view.DrinkActivity;

import java.util.ArrayList;
import java.util.List;

public class DrinkPresenter {
    private DrinkView mView;
    private DrinkActivity mActivity;
    private List<MenuItem> menu;

    public DrinkPresenter(DrinkActivity activity, DrinkView view) {
        mActivity = activity;
        mView = view;
        menu = new ArrayList<>();
    }

    public void loadMenu() {
        menu.add(new MenuItem("Pepsi", "Nước ngọt có gas", 20000, R.drawable.pepsi));
        menu.add(new MenuItem("Heineken", "Bia nhập khẩu", 30000, R.drawable.heineken));
        menu.add(new MenuItem("Tiger", "Bia Tiger", 25000, R.drawable.tiger));
        menu.add(new MenuItem("Sài Gòn Đỏ", "Bia Sài Gòn Đỏ", 22000, R.drawable.saigondo));
        mView.displayMenu(menu);
    }

    public void onItemSelected(int position) {
        MenuItem item = menu.get(position);
        Intent data = new Intent();
        data.putExtra("name", item.getName());
        data.putExtra("price", item.getPrice());
        mActivity.setResult(DrinkActivity.RESULT_OK, data);
        mActivity.finish();
    }

    public interface DrinkView {
        void displayMenu(List<MenuItem> items);
    }
}
