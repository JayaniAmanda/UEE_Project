package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignUpActivity extends AppCompatActivity {
    AwesomeValidation awesomeValidation;
    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        getSupportActionBar().setTitle("Sign Up");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        signUpBtn = findViewById(R.id.signup_tb);

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);

        String regexName = "[a-zA-Z\\s]+";
        String regexPhone = "[0]{1}[0-9]{9}$";
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        awesomeValidation.addValidation(this, R.id.name_et, RegexTemplate.NOT_EMPTY, R.string.name_req_err);
        awesomeValidation.addValidation(this, R.id.name_et, regexName, R.string.name_err);
        awesomeValidation.addValidation(this, R.id.email_et, RegexTemplate.NOT_EMPTY, R.string.email_req_err);
        awesomeValidation.addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.email_err);
        awesomeValidation.addValidation(this, R.id.phone_et, RegexTemplate.NOT_EMPTY, R.string.phone_req_err);
        awesomeValidation.addValidation(this, R.id.phone_et, regexPhone, R.string.phone_err);
        awesomeValidation.addValidation(this, R.id.pw_et, RegexTemplate.NOT_EMPTY, R.string.pwd_req_err);
        awesomeValidation.addValidation(this, R.id.pw_et, regexPassword, R.string.pwd_err);
        awesomeValidation.addValidation(this, R.id.con_pw_et, RegexTemplate.NOT_EMPTY, R.string.pwd_req_err);
        awesomeValidation.addValidation(this, R.id.con_pw_et, R.id.pw_et, R.string.con_pwd_err);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(SignUpActivity.this, "Sign up Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
