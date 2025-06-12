package com.nivz.lab4.presenter;

import android.app.Activity;
import android.content.Intent;

import com.nivz.lab4.view.DrinkActivity;
import com.nivz.lab4.view.FoodActivity;

public class MainPresenter {
    private Activity mActivity;
    private static final int REQ_FOOD = 100;
    private static final int REQ_DRINK = 200;

    public MainPresenter(Activity activity) {
        mActivity = activity;
    }

    public void onFoodButtonClicked() {
        Intent intent = new Intent(mActivity, FoodActivity.class);
        mActivity.startActivityForResult(intent, REQ_FOOD);
    }

    public void onDrinkButtonClicked() {
        Intent intent = new Intent(mActivity, DrinkActivity.class);
        mActivity.startActivityForResult(intent, REQ_DRINK);
    }

    public void handleActivityResult(int requestCode, int resultCode, Intent data, MainView callback) {
        if (resultCode != Activity.RESULT_OK || data == null) return;
        String name = data.getStringExtra("name");
        int price = data.getIntExtra("price", 0);
        if (requestCode == REQ_FOOD) {
            callback.onFoodSelected(name, price);
        } else if (requestCode == REQ_DRINK) {
            callback.onDrinkSelected(name, price);
        }
    }

    public interface MainView {
        void onFoodSelected(String name, int price);
        void onDrinkSelected(String name, int price);
    }
}