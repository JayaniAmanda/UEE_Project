package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchCategories extends AppCompatActivity {

    private ListView adListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_categories);

        adListView = findViewById(R.id.ads_lv);


        ArrayList<Ad> ads = new ArrayList<>();

        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));
        ads.add(new Ad(R.drawable.husky, "Husky Puppy", "Dogs, Piliyandala", "Rs. 50,000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);


        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchCategories.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchCategories.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}