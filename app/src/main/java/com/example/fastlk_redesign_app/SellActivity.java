package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;

import java.util.Calendar;

public class SellActivity extends AppCompatActivity {
    private Spinner transSp, fuelTySp, brandSp, modelSp;
    private ArrayAdapter<String> modelAdapter;
    //EditText modelYrEt, mileageEt, engCapEt, priceEt;
    private Button postAdBtn;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        transSp = findViewById(R.id.trans_sp);
        fuelTySp = findViewById(R.id.fuel_ty_sp);
        brandSp = findViewById(R.id.brand_sp);
        modelSp = findViewById(R.id.model_sp);
        postAdBtn = findViewById(R.id.post_ad_btn);
//        modelYrEt = findViewById(R.id.model_yr_et);
//        mileageEt = findViewById(R.id.mileage_et);
//        engCapEt = findViewById(R.id.engine_cap_et);
//        priceEt = findViewById(R.id.price_et);

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.model_yr_et, Range.closed(1900, Calendar.getInstance().get(Calendar.YEAR)), R.string.model_yr_error);
        awesomeValidation.addValidation(this, R.id.mileage_et, RegexTemplate.NOT_EMPTY, R.string.mileage_err);
        awesomeValidation.addValidation(this, R.id.engine_cap_et, RegexTemplate.NOT_EMPTY, R.string.eng_cap_err);
        awesomeValidation.addValidation(this, R.id.des_et, RegexTemplate.NOT_EMPTY, R.string.des_err);
        awesomeValidation.addValidation(this, R.id.price_et, RegexTemplate.NOT_EMPTY, R.string.price_err);
//        awesomeValidation.addValidation(this, R.id.trans_sp, RegexTemplate.NOT_EMPTY, R.string.price_err);

        ArrayAdapter<String> transAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.trans));
        transAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        transSp.setAdapter(transAdapter);

        ArrayAdapter<String> fuelTyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fuel_ty));
        fuelTyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        fuelTySp.setAdapter(fuelTyAdapter);

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.brands));
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSp.setAdapter(brandAdapter);

        brandSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    modelAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.toyota_models));
                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    modelSp.setAdapter(modelAdapter);
                } else{
                    modelAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bmw_models));
                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    modelSp.setAdapter(modelAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        postAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(SellActivity.this, "Ad Posted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}