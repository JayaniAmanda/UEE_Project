package com.example.fastlk_redesign_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class DogDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_details);

        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.labby,"image 1"));
        slideModels.add(new SlideModel(R.drawable.labby1,"image 2"));
        slideModels.add(new SlideModel(R.drawable.labby2,"image 3"));
        slideModels.add(new SlideModel(R.drawable.labby3,"image 4"));

        imageSlider.setImageList(slideModels, true);


        TextView feedback = findViewById(R.id.textViewfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogDetails.this, Feedback.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.home_iv);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}