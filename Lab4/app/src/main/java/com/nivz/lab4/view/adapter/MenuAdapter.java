package com.nivz.lab4.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nivz.lab4.R;
import com.nivz.lab4.model.MenuItem;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private int resourceLayout;
    private Context mContext;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull List<MenuItem> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(resourceLayout, parent, false);
        }

        MenuItem item = getItem(position);
        if (item != null) {
            ImageView img = view.findViewById(R.id.img_item);
            TextView tvName = view.findViewById(R.id.tv_name);
            TextView tvDesc = view.findViewById(R.id.tv_description);
            TextView tvPrice = view.findViewById(R.id.tv_price);

            img.setImageResource(item.getImageResId());
            tvName.setText(item.getName());
            tvDesc.setText(item.getDescription());
            tvPrice.setText(item.getPrice() + " VND");
        }

        return view;
    }
}
