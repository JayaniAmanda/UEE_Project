package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView propIv;
    private Button postAdBtn;
    private TextView signUpTv;


    ImageView animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propIv = findViewById(R.id.prop_iv);
        postAdBtn = findViewById(R.id.post_ad_btn);

        propIv.setOnClickListener(new View.OnClickListener() {
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

        View view = getLayoutInflater().inflate(R.layout.toolbar_default, null);
        signUpTv = view.findViewById(R.id.signup_tb);
        ImageView iv = view.findViewById(R.id.imageView6);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("huui", "onClick: ");
                System.out.println(signUpTv.getText());
            }
        });
        Log.i("hi", "onClick: ");
        //System.out.println(signUpTv.getText());
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                Log.i("hii", "onClick: ");
                System.out.println(signUpTv.getText());
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
    }
}