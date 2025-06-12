package com.nivz.lab3_2.adapter;

import static com.nivz.lab3_2.R.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nivz.lab3_2.R;
import com.nivz.lab3_2.model.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() { return fruitList.size(); }

    @Override
    public Object getItem(int position) { return fruitList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //+Kiểm tra convertView:
        // convertView là view cũ có thể được tái sử dụng.
        // Nếu nó null, chúng ta inflate một View mới từ list_item.xml để tránh tạo quá nhiều View gây tốn tài nguyên.
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        //+Lấy dữ liệu của item hiện tại:
        // Sử dụng position để lấy một Fruit từ fruitList.
        Fruit fruit = fruitList.get(position);

        //+Ánh xạ các thành phần trong list_item.xml:
        // Lấy ImageView, TextView từ convertView.
        ImageView imgFruit = convertView.findViewById(R.id.imgFruit);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDescription = convertView.findViewById(R.id.txtDescription);

        //+Gán dữ liệu vào giao diện:
        // Đặt ảnh, tên và mô tả vào ImageView và TextView.
        imgFruit.setImageResource(fruit.getImageId());
        txtName.setText(fruit.getName());
        txtDescription.setText(fruit.getDescription());

        //+Trả về convertView:
        // Đây là View đã được cập nhật nội dung, và nó sẽ hiển thị trong ListView.
        return convertView;
    }
}
