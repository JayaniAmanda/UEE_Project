package com.example.fastlk_redesign_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdAdapter extends ArrayAdapter<Ad> {
    private Context context;
    private int resource;

    public AdAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ad> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        ImageView adIv = convertView.findViewById(R.id.ad_iv);
        TextView nameTv = convertView.findViewById(R.id.name_tv);
        TextView subTv = convertView.findViewById(R.id.sub_tv);
        TextView priceTv = convertView.findViewById(R.id.price_tv);

        adIv.setImageResource(getItem(position).getImage());
        nameTv.setText(getItem(position).getName());
        subTv.setText(getItem(position).getDescription());
        priceTv.setText(getItem(position).getPrice());

        return convertView;
    }
}
