package com.nivz.lab7;

import android.Manifest;

public class MainPresenter {
    private final MainActivity view;
    private final MainModel model;

    private static final int REQUEST_CALL = 100;
    private static final int REQUEST_LOCATION = 101;

    public MainPresenter(MainActivity view) {
        this.view = view;
        this.model = new MainModel(view);
    }

    public void onCallClick(String phoneNumber) {
        if (model.isPermissionGranted(Manifest.permission.CALL_PHONE)) {
            view.makeCall(phoneNumber);
        } else {
            view.requestUserPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
    }

    public void onRequestLocation() {
        if (model.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            view.showToast("Đã được cấp quyền vị trí");
        } else {
            if (model.shouldShowRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                view.showToast("Ứng dụng cần quyền để truy cập vị trí");
            }
            view.requestUserPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
    }

    public void onPermissionResult(int requestCode, boolean granted, boolean dontAskAgain) {
        if (requestCode == REQUEST_CALL) {
            if (granted) {
                view.showToast("Đã được cấp quyền gọi");
            } else {
                view.showToast("Bạn cần cấp quyền để gọi điện");
            }
        } else if (requestCode == REQUEST_LOCATION) {
            if (granted) {
                view.showToast("Đã được cấp quyền vị trí");
            } else if (dontAskAgain) {
                view.showToast("Vui lòng cấp quyền trong Cài đặt");
                view.openAppSettings();
            } else {
                view.showToast("Bạn đã từ chối quyền vị trí");
            }
        }
    }
}
