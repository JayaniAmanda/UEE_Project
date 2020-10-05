package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class LocCatActivity extends AppCompatActivity {
    private Spinner catSp, subCatSp, locSp, subLocSp;
    private ArrayAdapter<String> catAdapter, subCatAdapter, locAdapter, subLocAdapter;
    private Button conBtn;
    //int count;
    String[] locationArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_cat);

        catSp = findViewById(R.id.cat_sp);
        subCatSp = findViewById(R.id.sub_cat_sp);
        locSp = findViewById(R.id.loc_sp);
        subLocSp = findViewById(R.id.sub_loc_sp);
        conBtn = findViewById(R.id.ok_btn);

        catAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.categories));
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSp.setAdapter(catAdapter);

        catSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    subCatAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.properties));
                    subCatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subCatSp.setAdapter(subCatAdapter);
                } else if (position == 1){
                    subCatAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.vehicles));
                    subCatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subCatSp.setAdapter(subCatAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        locAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.locations));
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locSp.setAdapter(locAdapter);

        locSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    subLocAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colombo));
                    subLocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subLocSp.setAdapter(subLocAdapter);
                } else if (position == 1){
                    subLocAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.matara));
                    subLocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subLocSp.setAdapter(subLocAdapter);
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
}