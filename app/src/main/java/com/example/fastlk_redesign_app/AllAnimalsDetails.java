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

public class AllAnimalsDetails extends AppCompatActivity {

    private ListView adListView;
    private Button catBtn, locBtn;
    private Spinner dialogSp, dialog2Sp;
    String[] petsArr, animalsArr, colomboArr, mataraArr;
    int dialogSpPos;
    ArrayAdapter<String> adapter;
    String a;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_animals_details);


        adListView = findViewById(R.id.ads_lv);
        catBtn = findViewById(R.id.cat_btn);
        locBtn = findViewById(R.id.loc_btn);

        ArrayList<Ad> ads = new ArrayList<>();

        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));
        ads.add(new Ad(R.drawable.labby, "Puppy", "Dogs, Piliyandala", "Rs. 40,000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);

        petsArr = getResources().getStringArray(R.array.pets);
        animalsArr = getResources().getStringArray(R.array.animals);
        colomboArr = getResources().getStringArray(R.array.colombo);
        mataraArr = getResources().getStringArray(R.array.matara);

        catBtn.setText(petsArr[0]+ " / " + animalsArr[0]);
        locBtn.setText(colomboArr[0]);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllAnimalsDetails.this);
                builder.setTitle("Select Category");
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                dialog2Sp = view.findViewById(R.id.dialog2_sp);
                setSpinner(dialogSp, R.array.pets);
                setSpinner(dialog2Sp, R.array.animals);
                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        a = petsArr[position];

                        /*if (position == 0){
                            setSpinner(dialog2Sp, R.array.pets);
                            dialogSpPos = 0;
                        } /*else if (position == 1){
                            setSpinner(dialog2Sp, R.array.vehicles);
                            dialogSpPos = 1;
                        }*/
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                dialog2Sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        b = animalsArr[position];




                        /*if(animalsArr[position] == "Related Details"){
                            catBtn.setText(petsArr[position] + " / " + "Related Details");
                        }
                        else if(animalsArr[position] == "Food"){
                            catBtn.setText(petsArr[position] + " / " + "Food");
                        }
                        else if(animalsArr[position] == "Veterinary"){
                            catBtn.setText(petsArr[position] + " / " + "Veterinary");
                        }
                        else{
                            catBtn.setText(petsArr[position] + " / " + "Accessories");
                        }
                        /*if (dialogSpPos == 0) catBtn.setText(petsArr[position]);
                        else if (dialogSpPos == 1) catBtn.setText(vehicleArr[position]);*/
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        catBtn.setText(a+ " / " + b);

                    }
                });



                builder.setView(view);
                builder.create().show();
            }
        });

        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllAnimalsDetails.this);
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


        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllAnimalsDetails.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllAnimalsDetails.this, MainActivity.class);
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