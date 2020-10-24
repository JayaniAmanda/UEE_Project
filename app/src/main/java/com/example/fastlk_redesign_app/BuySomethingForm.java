package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class BuySomethingForm extends AppCompatActivity {
    private ImageView myAccBtn;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_something_form);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.editTextTextPersonName2, RegexTemplate.NOT_EMPTY, R.string.des_err);
        awesomeValidation.addValidation(this, R.id.editTextTextMultiLine2, RegexTemplate.NOT_EMPTY, R.string.title_req_err);
        awesomeValidation.addValidation(this, R.id.editTextTextPersonName4, RegexTemplate.NOT_EMPTY, R.string.location_req_err);

        Button postad = findViewById(R.id.button2);
        postad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(BuySomethingForm.this, "Ad Posted!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuySomethingForm.this, MainActivity.class));
                }
            }
        });

        myAccBtn = findViewById(R.id.myaccountbtn);
        myAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuySomethingForm.this, MyAccount.class));
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

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuySomethingForm.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}