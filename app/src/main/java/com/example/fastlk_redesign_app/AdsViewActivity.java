package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdsViewActivity extends AppCompatActivity {
    private ListView adListView;
    private Button catBtn, locBtn;
    private Spinner dialogSp, dialog2Sp;
    String[] vehicleArr, propArr, colomboArr, mataraArr;
    int dialogSpPos;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_view);

        adListView = findViewById(R.id.ads_lv);
        catBtn = findViewById(R.id.cat_btn);
        locBtn = findViewById(R.id.loc_btn);

        ArrayList<Ad> ads = new ArrayList<>();

        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));
        ads.add(new Ad(R.drawable.home, "Home", "Houses, Piliyandala", "Rs. 100,000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);

        //vehicleArr = getResources().getStringArray(R.array.vehicles);
        propArr = getResources().getStringArray(R.array.properties);
        colomboArr = getResources().getStringArray(R.array.colombo);
        mataraArr = getResources().getStringArray(R.array.matara);

        catBtn.setText(propArr[0]);
        locBtn.setText(colomboArr[0]);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
                builder.setTitle("Select Sub Category");
                View view = getLayoutInflater().inflate(R.layout.spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                //dialog2Sp = view.findViewById(R.id.dialog2_sp);
                setSpinner(dialogSp, R.array.properties);
//                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        if (position == 0){
//                            setSpinner(dialog2Sp, R.array.properties);
//                            dialogSpPos = 0;
//                        } else if (position == 1){
//                            setSpinner(dialog2Sp, R.array.vehicles);
//                            dialogSpPos = 1;
//                        }
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });

                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        if (dialogSpPos == 0)
                            //catBtn.setText(view.getContext().getText(position));
                            catBtn.setText(propArr[position]);
//                        else if (dialogSpPos == 1)
//                            catBtn.setText(vehicleArr[position]);
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
                builder.setView(view).create().show();
            }
        });

        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
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
                builder.setView(view).create().show();
            }
        });
    }

    public void setSpinner(Spinner spinner, int list){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(list));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}