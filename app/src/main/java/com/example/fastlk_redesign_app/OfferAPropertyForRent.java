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

public class OfferAPropertyForRent extends AppCompatActivity {

    private Spinner catSpin, locSpin, subLocSpin;
    ArrayAdapter<String> adapter;
    private Button continueBtn;
    private ImageView myAccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_a_property_for_rent);

        catSpin = findViewById(R.id.ccatspin);
        locSpin = findViewById(R.id.clocspin);
        subLocSpin = findViewById(R.id.cslocspin);
        continueBtn = findViewById(R.id.continuebtn);

        setSpinner(catSpin, R.array.categoryopfr);

        setSpinner(locSpin, R.array.locations);

        locSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subLocSpin, R.array.colombo);
                } else if (position == 1){
                    setSpinner(subLocSpin, R.array.matara);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SellProperty.class));
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfferAPropertyForRent.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfferAPropertyForRent.this, MainActivity.class);
                startActivity(intent);
            }
        });

        myAccBtn = findViewById(R.id.myaccountbtn);
        myAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OfferAPropertyForRent.this, MyAccount.class));
            }
        });
    }

    public void setSpinner(Spinner spinner, int list){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(list));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}