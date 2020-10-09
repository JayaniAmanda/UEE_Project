package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AdsViewActivity extends AppCompatActivity {
    private ListView adListView;
    private Button catBtn, locBtn;
    private Spinner dialogSp, dialog2Sp;
    String[] vehicleArr, propArr, colomboArr, mataraArr, locArr;
    int dialogSpPos;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_view);

        adListView = findViewById(R.id.ads_lv);
        catBtn = findViewById(R.id.cat_btn);
        locBtn = findViewById(R.id.loc_btn);

        vehicleArr = getResources().getStringArray(R.array.vehicles);
        propArr = getResources().getStringArray(R.array.properties);
        colomboArr = getResources().getStringArray(R.array.colombo);
        mataraArr = getResources().getStringArray(R.array.matara);
        locArr = getResources().getStringArray(R.array.locations);

        TextView signUpTb = findViewById(R.id.signup_tb);
        signUpTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(AdsViewActivity.this, SignUpActivity.class));
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdsViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdsViewActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        ArrayList<Ad> ads = new ArrayList<>();
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.house, "House for sale", "Houses, Piliyandala", "Rs. 100,000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);

        catBtn.setText(propArr[0]);
        locBtn.setText(colomboArr[0]);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
                builder.setTitle(R.string.sub_cat);
                View view = getLayoutInflater().inflate(R.layout.spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                setSpinner(dialogSp, propArr);

                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        catBtn.setText(propArr[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setView(view).create().show();
            }
        });

        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
                builder.setTitle(R.string.loc_sel);
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                dialog2Sp = view.findViewById(R.id.dialog2_sp);
                setSpinner(dialogSp, locArr);

                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            setSpinner(dialog2Sp, colomboArr);
                            dialogSpPos = 0;
                        } else if (position == 1){
                            setSpinner(dialog2Sp, mataraArr);
                            dialogSpPos = 1;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                dialog2Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (dialogSpPos == 0) locBtn.setText(colomboArr[position]);
                        else if (dialogSpPos == 1) locBtn.setText(mataraArr[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setView(view).create().show();
            }
        });
    }

    public void setSpinner(Spinner spinner, String[] array){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}