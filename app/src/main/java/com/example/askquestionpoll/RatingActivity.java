package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        RatingBar rating1=(RatingBar) findViewById(R.id.rating1);
        RatingBar rating2=(RatingBar) findViewById(R.id.rating2);
        RatingBar rating3=(RatingBar) findViewById(R.id.rating3);
        RatingBar rating4=(RatingBar) findViewById(R.id.rating4);
        TextView txt1=findViewById(R.id.txt1);
        TextView txt2=findViewById(R.id.txt2);
        TextView txt3=findViewById(R.id.txt3);
        rating1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(), String.valueOf(v), Toast.LENGTH_SHORT).show();
            }
        });
        rating2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(), String.valueOf(v), Toast.LENGTH_SHORT).show();
                txt1.setText("Rating is :"+String.valueOf(v));
            }
        });
        rating3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(), String.valueOf(v), Toast.LENGTH_SHORT).show();
                txt2.setText("Rating is :"+String.valueOf(v));
            }
        });
        rating4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(), String.valueOf(v), Toast.LENGTH_SHORT).show();
                txt3.setText("Rating is :"+String.valueOf(v));
            }
        });

    }
}