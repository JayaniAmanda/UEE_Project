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
    String[] vehicleArr, propArr, colomboArr, mataraArr,electronicArr,locArr;
    int dialogSpPos;
    ImageView home;
    TextView feedback,signIn,signUp;

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
            home = findViewById(R.id.home_iv);
            signIn = findViewById(R.id.textView1);
            signUp = findViewById(R.id.signup_tb);
            locArr = getResources().getStringArray(R.array.locations);

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

            signUp.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    startActivity(new Intent(ElectronicAdsViewActivity.this, SignUpActivity.class));
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

            adListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ElectronicAdsViewActivity.this, ElectronicDetailsActivity.class);
                    startActivity(intent);
                }
            });

            catBtn.setText(electronicArr[0]);
            locBtn.setText(mataraArr[0]);

            catBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ElectronicAdsViewActivity.this);
                    builder.setTitle(R.string.sub_cat);
                    View view = getLayoutInflater().inflate(R.layout.spinner, null);
                    dialogSp = view.findViewById(R.id.dialog_sp);
                    setSpinner(dialogSp, electronicArr);

                    dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            catBtn.setText(electronicArr[position]);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(ElectronicAdsViewActivity.this);
                    builder.setTitle("Choose Location");
                    View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                    dialogSp = view.findViewById(R.id.dialog_sp);
                    dialog2Sp = view.findViewById(R.id.dialog2_sp);
                    setSpinner(dialogSp, locArr);
                    dialogSp.setSelection(1);
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

    public void setSpinner(Spinner spinner, String[] array){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}