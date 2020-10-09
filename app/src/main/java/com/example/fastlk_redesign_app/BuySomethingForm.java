package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuySomethingForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_something_form);

        Button postad = findViewById(R.id.button2);
        postad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuySomethingForm.this, "Successfully posted.", Toast.LENGTH_SHORT).show();
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuySomethingForm.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuySomethingForm.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}