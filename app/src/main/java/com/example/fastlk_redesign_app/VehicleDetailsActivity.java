package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        ImageSlider imageSlider = findViewById(R.id.vehicle_slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.labby,"image 1"));
        slideModels.add(new SlideModel(R.drawable.labby1,"image 2"));
        slideModels.add(new SlideModel(R.drawable.labby2,"image 3"));
        slideModels.add(new SlideModel(R.drawable.labby3,"image 4"));

        imageSlider.setImageList(slideModels, false);

    }
}