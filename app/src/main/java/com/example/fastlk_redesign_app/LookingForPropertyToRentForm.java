package com.example.fastlk_redesign_app;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class LookingForPropertyToRentForm  extends AppCompatActivity{

      Button submitBtn;
      AwesomeValidation awesomeValidation;
      ImageView home, myAccBtn;
      TextView feedback;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_looking_for_property_to_rent_form);


            feedback = findViewById(R.id.textViewfeedback);
            home = findViewById(R.id.home_iv);
            submitBtn = findViewById(R.id.button2);

            feedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.fastlk_redesign_app.LookingForPropertyToRentForm.this, Feedback.class);
                    startActivity(intent);
                }
            });

            myAccBtn = findViewById(R.id.myaccountbtn);
            myAccBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LookingForPropertyToRentForm.this, MyAccount.class));
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.fastlk_redesign_app.LookingForPropertyToRentForm.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

            awesomeValidation.addValidation(this, R.id.editTextTextPersonName2, RegexTemplate.NOT_EMPTY, R.string.des_err);
            awesomeValidation.addValidation(this, R.id.editTextTextMultiLine2, RegexTemplate.NOT_EMPTY, R.string.title_req_err);
            awesomeValidation.addValidation(this, R.id.editTextTextPersonName4, RegexTemplate.NOT_EMPTY, R.string.location_req_err);

            submitBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (awesomeValidation.validate()) {
                        Toast.makeText(LookingForPropertyToRentForm.this, "Ad Posted!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LookingForPropertyToRentForm.this, MainActivity.class));
                    }
                }
            });
        }
    }


