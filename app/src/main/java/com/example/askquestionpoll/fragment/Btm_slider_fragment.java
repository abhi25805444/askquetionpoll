package com.example.askquestionpoll.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.askquestionpoll.R;
import com.google.android.material.slider.Slider;

public class Btm_slider_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.activity_seek_bar, container, false);
        Slider seekBar=root.findViewById(R.id.slide1);
        Slider seekBar5=root.findViewById(R.id.seekbar5);
        TextView txt1=root.findViewById(R.id.txt1);
        Slider seekBar2=root.findViewById(R.id.seekbar2);
        TextView txt2=root.findViewById(R.id.txt2);
        TextView txt3=root.findViewById(R.id.txt3);
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
        return root;
    }
}