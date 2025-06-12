package com.nivz.lab4.presenter;

import android.content.Intent;

import com.nivz.lab4.model.MenuItem;

import java.util.ArrayList;
import java.util.List;
import com.nivz.lab4.R;
import com.nivz.lab4.view.FoodActivity;

public class FoodPresenter {
    private FoodView mView;
    private FoodActivity mActivity;
    private List<MenuItem> menu;

    public FoodPresenter(FoodActivity activity, FoodView view) {
        mActivity = activity;
        mView = view;
        menu = new ArrayList<>();
    }

    public void loadMenu() {
        menu.add(new MenuItem("Phở Hà Nội", "Bún nước truyền thống", 50000, R.drawable.pho));
        menu.add(new MenuItem("Bún Bò Huế", "Chua cay Huế", 60000, R.drawable.bunbo));
        menu.add(new MenuItem("Mì Quảng", "Mì Quảng Đà Nẵng", 55000, R.drawable.miquang));
        menu.add(new MenuItem("Hủ Tiếu Sài Gòn", "Hủ tiếu Nam Vang", 45000, R.drawable.hutieu));
        mView.displayMenu(menu);
    }

    public void onItemSelected(int position) {
        MenuItem item = menu.get(position);
        Intent data = new Intent();
        data.putExtra("name", item.getName());
        data.putExtra("price", item.getPrice());
        mActivity.setResult(FoodActivity.RESULT_OK, data);
        mActivity.finish();
    }

    public interface FoodView {
        void displayMenu(List<MenuItem> items);
    }
}
