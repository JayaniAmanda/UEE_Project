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

public class LocCatActivity extends AppCompatActivity {
    private Spinner catSp, subCatSp, locSp, subLocSp;
    ArrayAdapter<String> adapter;
    private Button conBtn;
    private ImageView myAccBtn;
    //int count;
    String[] propArr, vehicleArr, catArr, locArr, colomboArr, mataraArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_cat);

        catSp = findViewById(R.id.cat_sp);
        subCatSp = findViewById(R.id.sub_cat_sp);
        locSp = findViewById(R.id.loc_sp);
        subLocSp = findViewById(R.id.sub_loc_sp);
        conBtn = findViewById(R.id.ok_btn);

        propArr = getResources().getStringArray(R.array.properties);
        vehicleArr = getResources().getStringArray(R.array.vehicles);
        catArr = getResources().getStringArray(R.array.categories);
        locArr = getResources().getStringArray(R.array.locations);
        colomboArr = getResources().getStringArray(R.array.colombo);
        mataraArr = getResources().getStringArray(R.array.matara);

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocCatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        myAccBtn = findViewById(R.id.myaccountbtn);
        myAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocCatActivity.this, MyAccount.class));
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocCatActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        setSpinner(catSp, catArr);

        catSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subCatSp, propArr);
                } else if (position == 1){
                    setSpinner(subCatSp, vehicleArr);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setSpinner(locSp, locArr);

        locSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setSpinner(subLocSp, colomboArr);
                } else if (position == 1){
                    setSpinner(subLocSp, mataraArr);
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
                startActivity(new Intent(getApplicationContext(), SellActivity.class));
            }
        });

    }

    public void setSpinner(Spinner spinner, String[] array){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}