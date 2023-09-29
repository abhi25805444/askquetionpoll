package com.example.askquestionpoll;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

public class seekBarActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        Slider seekBar=findViewById(R.id.slide1);
        Slider seekBar5=findViewById(R.id.seekbar5);
        TextView txt1=findViewById(R.id.txt1);
        Slider seekBar2=findViewById(R.id.seekbar2);
        TextView txt2=findViewById(R.id.txt2);
        TextView txt3=findViewById(R.id.txt3);
        seekBar5.setHorizontalScrollbarThumbDrawable(getResources().getDrawable(R.drawable.thumb_slider));
        seekBar5.setVerticalScrollbarThumbDrawable(getResources().getDrawable(R.drawable.thumb_slider));


        seekBar2.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                txt2.setText(value + "%");
                txt3.setText(value + "/100");
            }
        });
        seekBar.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange( Slider slider, float value, boolean fromUser) {

                txt1.setText("Distance " + value + "KM");
                txt1.setVisibility(View.VISIBLE);

            }
        });

    }
}