package com.nivz.lab2.presenter;

import com.nivz.lab2.model.RandomModel;
import com.nivz.lab2.view.RandomView;

public class RandomPresenter {
    private final RandomView view;
    private final RandomModel model;

    public RandomPresenter(RandomView view) {
        this.view = view;
        this.model = new RandomModel();
    }

    public void onGenerateClicked() {
        try {
            int min = view.getMin();
            int max = view.getMax();
            if (min > max) {
                view.showError("Min must be <= Max");
                return;
            }
            int result = model.generateRandom(min, max);
            view.showResult(String.valueOf(result));
        } catch (NumberFormatException e) {
            view.showError("Invalid input");
        }
    }
}