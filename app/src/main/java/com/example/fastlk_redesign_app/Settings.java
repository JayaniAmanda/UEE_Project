package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Settings extends AppCompatActivity {
    private Button updatedetailsbtn, changepwbtn;
    AwesomeValidation awesomeValidation1, awesomeValidation2;
    ArrayAdapter<String> adapter;
    private Spinner locspin, subspin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        updatedetailsbtn = findViewById(R.id.updatedetailsbtn);
        changepwbtn = findViewById(R.id.changepwbtn);
        locspin = findViewById(R.id.locationspin);
        subspin = findViewById(R.id.sublocationspin);

        setSpinner(locspin, R.array.locations);

        locspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subspin, R.array.colombo);
                } else if (position == 1){
                    setSpinner(subspin, R.array.matara);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        awesomeValidation1 = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation2 = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation1.addValidation(this, R.id.usernametxt, RegexTemplate.NOT_EMPTY, R.string.name_error);
        awesomeValidation1.addValidation(this, R.id.emailtxt, RegexTemplate.NOT_EMPTY, R.string.email_error);
        awesomeValidation1.addValidation(this, R.id.locationspin, RegexTemplate.NOT_EMPTY, R.string.location_error);
        awesomeValidation1.addValidation(this, R.id.sublocationspin, RegexTemplate.NOT_EMPTY, R.string.sublocation_error);
        awesomeValidation2.addValidation(this, R.id.currentpwtxt, RegexTemplate.NOT_EMPTY, R.string.currentpw_error);
        awesomeValidation2.addValidation(this, R.id.newpwtxt, RegexTemplate.NOT_EMPTY, R.string.newpw_error);
        awesomeValidation2.addValidation(this, R.id.confirmnewpwtxt, RegexTemplate.NOT_EMPTY, R.string.confirmnewpw_error);

        updatedetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation1.validate()){
                    Toast.makeText(Settings.this, "Details Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changepwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation2.validate()){
                    Toast.makeText(Settings.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void setSpinner(Spinner spinner, int list){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(list));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}