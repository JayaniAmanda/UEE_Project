package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SellProperty extends AppCompatActivity {
    private Spinner perches;
    private ArrayAdapter<String> adapter;
    private Button postAdbtn;
    AwesomeValidation awesomeValidation;
    private ImageView myAccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_property);

        perches = findViewById(R.id.perchspin);
        postAdbtn = findViewById(R.id.postbtn);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.landsizetxt, RegexTemplate.NOT_EMPTY, R.string.landsize_error);
        awesomeValidation.addValidation(this, R.id.titletxt, RegexTemplate.NOT_EMPTY, R.string.title_error);
        awesomeValidation.addValidation(this, R.id.descriptiontxt, RegexTemplate.NOT_EMPTY, R.string.description_error);
        awesomeValidation.addValidation(this, R.id.pricetxt, RegexTemplate.NOT_EMPTY, R.string.price_error);

        setSpinner(perches, R.array.landtypes);

        myAccBtn = findViewById(R.id.myaccountbtn);
        myAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellProperty.this, MyAccount.class));
            }
        });


        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellProperty.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellProperty.this, MainActivity.class);
                startActivity(intent);
            }
        });

        postAdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(SellProperty.this, "Ad Posted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void setSpinner(Spinner spinner, int list){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(list));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}