package com.torkian.warehouse.app;

/**
 * Created by btorkian on 4/20/14.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.torkian.warehouse.app.product.Product;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList <Product>  data;
    private static LayoutInflater inflater=null;


    public LazyAdapter(Activity a, ArrayList <Product> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.simple_list_item_1, null);

        TextView product = (TextView)vi.findViewById(R.id.text1);
        TextView dis = (TextView)vi.findViewById(R.id.text2);
        //TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image

        Product currentProduct = new Product();
        currentProduct = data.get(position);

        // Setting all values in listview
        product.setText(currentProduct.getName());
        dis.setText(currentProduct.getDis());
        thumb_image.setImageDrawable(currentProduct.getImage());
        //duration.setText(song.get(CustomizedListView.KEY_DURATION));
        //imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}
