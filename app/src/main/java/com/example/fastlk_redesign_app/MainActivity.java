package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ImageView propIv;
private Button postAdBtn;



    ImageView animals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propIv = findViewById(R.id.prop_iv);
        postAdBtn = findViewById(R.id.post_ad_btn);

        propIv .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdsViewActivity.class));
            }
        });

        postAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SelectAdTypeActivity.class));
            }
        });

        animals = findViewById(R.id.imageViewAnimal);
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllAnimalsDetails.class);
                startActivity(intent);
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        TextView signIn = findViewById(R.id.textView1);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        ImageButton search = findViewById(R.id.imageButton4);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchCategories.class);
                startActivity(intent);
            }
        });

        //ImageView electronics = findViewById(R.id.imageView6);

        TextView electronics = findViewById(R.id.textView5);

        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ElectronicAdsViewActivity.class));
            }
        });


    }
}