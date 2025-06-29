    package com.nivz.lab7;

    import android.Manifest;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.net.Uri;
    import android.os.Build;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.app.ActivityCompat;
    import androidx.core.content.ContextCompat;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity {
        private static final int REQUEST_CALL = 100;
        private static final int REQUEST_LOCATION = 101;
        private MainPresenter presenter;
        private String phoneNumber;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            presenter = new MainPresenter(this);

            TextView tvPhone = findViewById(R.id.tvPhoneNumber);
            phoneNumber = "tel:" + tvPhone.getText().toString();

            Button btnCall = findViewById(R.id.btnCall);
            Button btnRequest = findViewById(R.id.btnRequestPermission);
            Button btnSettings = findViewById(R.id.btnOpenSettingPermission);

            btnCall.setOnClickListener(v -> presenter.onCallClick(phoneNumber));
            btnRequest.setOnClickListener(v -> presenter.onRequestLocation());
            btnSettings.setOnClickListener(v -> openAppSettings());
        }

        public void showToast(String msg) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        public void openAppSettings() {
            Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivity(intent);
        }

        public void makeCall(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(phoneNumber));
            startActivity(intent);
        }

        public void requestUserPermissions(String[] permissions, int requestCode) {
            requestPermissions(permissions, requestCode);
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results) {
            super.onRequestPermissionsResult(requestCode, permissions, results);
            boolean granted = results.length > 0 && results[0] == android.content.pm.PackageManager.PERMISSION_GRANTED;
            boolean dontAskAgain = false;
            if (!granted) {
                dontAskAgain = !shouldShowRequestPermissionRationale(permissions[0]);
            }
            presenter.onPermissionResult(requestCode, granted, dontAskAgain);
        }
    }