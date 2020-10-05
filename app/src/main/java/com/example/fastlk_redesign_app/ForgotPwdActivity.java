package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class ForgotPwdActivity extends AppCompatActivity {
    AwesomeValidation awesomeValidation;
    Button resetPwdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        resetPwdBtn = findViewById(R.id.reset_pwd_btn);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.email_et, "abc@gmail.com", R.string.incorrect_email_err);

        resetPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(ForgotPwdActivity.this, "Email is sent!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}