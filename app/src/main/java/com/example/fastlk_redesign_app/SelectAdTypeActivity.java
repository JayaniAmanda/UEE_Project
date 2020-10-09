package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectAdTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ad_type);

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAdTypeActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAdTypeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectAdTypeActivity.this, LocCatActivity.class));
            }
        });

        Button buysomething = findViewById(R.id.looking_something_btn);
        buysomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectAdTypeActivity.this, LookingForSomethingToBuy.class));
            }
        });

        Button offerproperty = findViewById(R.id.offer_property_btn);
        offerproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectAdTypeActivity.this, OfferAPropertyForRent.class));
            }
        });
        Button looksomething = findViewById(R.id.looking_property_btn);
        looksomething.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SelectAdTypeActivity.this, LookingForPropertyToRent.class));
            }
        });
    }
}