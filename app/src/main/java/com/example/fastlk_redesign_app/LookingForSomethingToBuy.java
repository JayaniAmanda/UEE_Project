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

public class LookingForSomethingToBuy extends AppCompatActivity {

    private Spinner catSp, subCatSp, locSp, subLocSp;
    ArrayAdapter<String> adapter;
    private Button conBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_for_something_to_buy);


        catSp = findViewById(R.id.cat_sp);
        subCatSp = findViewById(R.id.sub_cat_sp);
        locSp = findViewById(R.id.loc_sp);
        subLocSp = findViewById(R.id.sub_loc_sp);
        conBtn = findViewById(R.id.ok_btn);

        setSpinner(catSp, R.array.categoriesone);

        catSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subCatSp, R.array.vehicles);
                } else if (position == 2){
                    setSpinner(subCatSp, R.array.pets);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setSpinner(locSp, R.array.locations);

        locSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subLocSp, R.array.colombo);
                } else if (position == 1){
                    setSpinner(subLocSp, R.array.matara);
                }
                //count = 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        new CountDownTimer(10000, 1000){
//
//            @Override
//            public void onTick(long l) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                count = 1;
//            }
//        }.start();

        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BuySomethingForm.class));
            }
        });


        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LookingForSomethingToBuy.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LookingForSomethingToBuy.this, MainActivity.class);
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