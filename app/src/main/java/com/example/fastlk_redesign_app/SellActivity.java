package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.util.ArrayList;
import java.util.Calendar;

public class SellActivity extends AppCompatActivity {
    private Spinner transSp, fuelTySp, brandSp, modelSp;
    private ArrayAdapter<String> modelAdapter;
    //EditText modelYrEt, mileageEt, engCapEt, priceEt;
    private EditText fuelTyEt;
    private Button postAdBtn;
    private String[] transArr, fuelTyArr, brandsArr, toyotaArr, bmwArr;
    boolean[] checkedItems;
    ArrayList<String> selectedItems = new ArrayList<>();
    AwesomeValidation awesomeValidation;
    private ImageView myAccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        transSp = findViewById(R.id.trans_sp);
        //fuelTySp = findViewById(R.id.fuel_ty_sp);
        brandSp = findViewById(R.id.brand_sp);
        modelSp = findViewById(R.id.model_sp);
        postAdBtn = findViewById(R.id.post_ad_btn);
        fuelTyEt = findViewById(R.id.fuel_ty_et);
        transArr = getResources().getStringArray(R.array.trans);
        fuelTyArr = getResources().getStringArray(R.array.fuel_ty);
        brandsArr = getResources().getStringArray(R.array.brands);
        toyotaArr = getResources().getStringArray(R.array.toyota_models);
        bmwArr = getResources().getStringArray(R.array.bmw_models);
        checkedItems = new boolean[fuelTyArr.length];
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

        ImageView home = findViewById(R.id.home_iv);
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
        awesomeValidation.addValidation(this, R.id.fuel_ty_et, RegexTemplate.NOT_EMPTY, R.string.fuel_ty_err);
        awesomeValidation.addValidation(this, R.id.engine_cap_et, RegexTemplate.NOT_EMPTY, R.string.eng_cap_err);
        awesomeValidation.addValidation(this, R.id.des_et, RegexTemplate.NOT_EMPTY, R.string.des_err);
        awesomeValidation.addValidation(this, R.id.price_et, RegexTemplate.NOT_EMPTY, R.string.price_err);
//        awesomeValidation.addValidation(this, R.id.trans_sp, RegexTemplate.NOT_EMPTY, R.string.price_err);

        ArrayAdapter<String> transAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, transArr);
        transAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        transSp.setAdapter(transAdapter);

//        ArrayAdapter<String> fuelTyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fuelTyArr);
//        fuelTyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
//        fuelTySp.setAdapter(fuelTyAdapter);

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, brandsArr);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSp.setAdapter(brandAdapter);

        brandSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    modelAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, toyotaArr);
                } else{
                    modelAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, bmwArr);
                }
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                modelSp.setAdapter(modelAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fuelTyEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SellActivity.this);
                builder.setTitle(R.string.fuel_ty_sel);
                builder.setMultiChoiceItems(fuelTyArr, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked){
                            selectedItems.add(fuelTyArr[which]);
                        } else {
                            selectedItems.remove(fuelTyArr[which]);
                        }
                    }
                });

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = TextUtils.join(",", selectedItems.toArray());
                        fuelTyEt.setText(s);
                    }
                });
                builder.create().show();
            }
        });

        myAccBtn = findViewById(R.id.myaccountbtn);
        myAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellActivity.this, MyAccount.class));
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