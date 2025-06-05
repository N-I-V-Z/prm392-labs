package com.nivz.lab2.presenter;

import com.nivz.lab2.model.CalculatorModel;
import com.nivz.lab2.view.CalculatorView;

public class CalculatorPresenter {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
        this.model = new CalculatorModel();
    }

    public void onAddClicked() {
        try {
            double kq = model.add(view.getSo1(), view.getSo2());
            view.showResult(String.valueOf(kq));
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void onSubClicked() {
        try {
            double kq = model.sub(view.getSo1(), view.getSo2());
            view.showResult(String.valueOf(kq));
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void onMulClicked() {
        try {
            double kq = model.mul(view.getSo1(), view.getSo2());
            view.showResult(String.valueOf(kq));
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void onDivClicked() {
        try {
            double kq = model.div(view.getSo1(), view.getSo2());
            view.showResult(String.valueOf(kq));
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
}