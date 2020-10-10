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
private ImageView propIv, vehiIv, elecIv;
private Button postAdBtn, myAccBtn;

    ImageView animals, vehicles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propIv = findViewById(R.id.prop_iv);
        postAdBtn = findViewById(R.id.post_ad_btn);
        vehiIv = findViewById(R.id.vehi_vi);
        //myAccBtn = findViewById(R.id.myaccountbtn);
        elecIv = findViewById(R.id.elect_iv);


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
                //startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                //startActivity(new Intent(MainActivity.this, SignInActivity.class));
            }
        });

//        myAccBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MyAccount.class));
//            }
//        });


        vehiIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VehicleAdsView.class));
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

        TextView signUpTb = findViewById(R.id.signup_tb);
        signUpTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, SignUpActivity.class));
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


        //TextView electronics = findViewById(R.id.textView5);

        elecIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ElectronicAdsViewActivity.class));
            }
        });


    }
}