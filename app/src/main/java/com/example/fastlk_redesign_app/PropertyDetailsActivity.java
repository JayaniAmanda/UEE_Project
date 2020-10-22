package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        ImageSlider imageSlider = findViewById(R.id.prop_slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.house,"image 1"));
        slideModels.add(new SlideModel(R.drawable.home1,"image 2"));
        slideModels.add(new SlideModel(R.drawable.home2,"image 3"));
        slideModels.add(new SlideModel(R.drawable.home3,"image 4"));

        imageSlider.setImageList(slideModels, false);
    }
}