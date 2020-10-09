package com.example.fastlk_redesign_app;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ElectronicAdsViewActivity extends AppCompatActivity {
    private ListView adListView;
    private Button catBtn, locBtn;
    private Spinner dialogSp, dialog2Sp;
    String[] vehicleArr, propArr, colomboArr, mataraArr,electronicArr;
    int dialogSpPos;
    ImageView home;
    TextView feedback,signIn;

    ArrayAdapter<String> adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_electronic_ads_view);


            adListView = findViewById(R.id.ads_lv);
            catBtn = findViewById(R.id.cat_btn);
            locBtn = findViewById(R.id.loc_btn);
            vehicleArr = getResources().getStringArray(R.array.vehicles);
            propArr = getResources().getStringArray(R.array.properties);
            colomboArr = getResources().getStringArray(R.array.colombo);
            mataraArr = getResources().getStringArray(R.array.matara);
            electronicArr = getResources().getStringArray(R.array.electronics);
            feedback = findViewById(R.id.textViewfeedback);
            home = findViewById(R.id.imageView6);
            signIn = findViewById(R.id.textView1);

            feedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.fastlk_redesign_app.ElectronicAdsViewActivity.this, Feedback.class);
                    startActivity(intent);
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.fastlk_redesign_app.ElectronicAdsViewActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ElectronicAdsViewActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            });

            ArrayList<Ad> ads = new ArrayList<>();

            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));
            ads.add(new Ad(R.drawable.iphone, "Apple iPhone 11", "phones, Weligama", "Rs. 150,000"));

            AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
            adListView.setAdapter(adAdapter);

            catBtn.setText(electronicArr[1]);
            locBtn.setText(mataraArr[1]);

            catBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ElectronicAdsViewActivity.this);
                    builder.setTitle("Select Category");
                    View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                    dialogSp = view.findViewById(R.id.dialog_sp);
                    dialog2Sp = view.findViewById(R.id.dialog2_sp);
                    setSpinner(dialogSp, R.array.categories);
                    dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0){
                                setSpinner(dialog2Sp, R.array.properties);
                                dialogSpPos = 0;
                            } else if (position == 1){
                                setSpinner(dialog2Sp, R.array.vehicles);
                                dialogSpPos = 1;
                            } else if (position == 2) {
                                setSpinner(dialog2Sp, R.array.electronics);
                                dialogSpPos = 2;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    dialog2Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (dialogSpPos == 0) catBtn.setText(propArr[position]);
                            else if (dialogSpPos == 1) catBtn.setText(vehicleArr[position]);
                            else if (dialogSpPos == 2) catBtn.setText(electronicArr[position]);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setView(view);
                    builder.create().show();
                }
            });

            locBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ElectronicAdsViewActivity.this);
                    builder.setTitle("Select Location");
                    View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                    dialogSp = view.findViewById(R.id.dialog_sp);
                    dialog2Sp = view.findViewById(R.id.dialog2_sp);
                    setSpinner(dialogSp, R.array.locations);

                    dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0){
                                setSpinner(dialog2Sp, R.array.colombo);
                                dialogSpPos = 0;
                            } else if (position == 1){
                                setSpinner(dialog2Sp, R.array.matara);
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

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setView(view);
                    builder.create().show();
                }
            });
        }

    public void setSpinner(Spinner spinner, int list){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(list));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}