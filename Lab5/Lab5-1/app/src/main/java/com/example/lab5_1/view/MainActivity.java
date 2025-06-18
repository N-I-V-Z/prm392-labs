package com.example.lab5_1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5_1.R;
import com.example.lab5_1.adapter.UserAdapter;
import com.example.lab5_1.model.User;
import com.example.lab5_1.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity {
    private UserPresenter presenter;
    private UserAdapter adapter;
    private RecyclerView recyclerView;

    private EditText edtUsername, edtFullname, edtEmail;

    private int editPos = -1; // -1 là thêm mới
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        presenter = new UserPresenter();

        recyclerView = findViewById(R.id.recyclerView);
        edtUsername = findViewById(R.id.etUsername);
        edtFullname = findViewById(R.id.etFullname);
        edtEmail = findViewById(R.id.etEmail);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new UserAdapter(presenter.getUsers(), new UserAdapter.OnUserActionListener() {
            @Override
            public void onEdit(int position) {
                User u = presenter.getUsers().get(position);
                edtUsername.setText(u.getUsername());
                edtFullname.setText(u.getFullname());
                edtEmail.setText(u.getEmail());
                editPos = position;
            }

            @Override
            public void onDelete(int position) {
                presenter.deleteUser(position);
                adapter.notifyItemRemoved(position);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void onSave(View v) {
        String username = edtUsername.getText().toString().trim();
        String fullname = edtFullname.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        if (username.isEmpty() || fullname.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(username, fullname, email);

        if (editPos == -1) {
            presenter.addUser(user);
            adapter.notifyItemInserted(presenter.getUsers().size() - 1);
        } else {
            presenter.updateUser(editPos, user);
            adapter.notifyItemChanged(editPos);
            editPos = -1;
        }

        edtUsername.setText("");
        edtFullname.setText("");
        edtEmail.setText("");
    }
}