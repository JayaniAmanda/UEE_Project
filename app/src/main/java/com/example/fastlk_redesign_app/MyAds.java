package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAds extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    private ListView adListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ads);

        ArrayList<Ad> ads = new ArrayList<>();
        adListView = findViewById(R.id.ads_lv);

        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));
        ads.add(new Ad(R.drawable.car, "lamborghini Gallardo", "Supercar, Kelaniya", "Rs. 100,000,000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAds.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAds.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}