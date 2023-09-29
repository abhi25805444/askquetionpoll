package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        SwitchMaterial switchMaterial1=findViewById(R.id.btn_switch_1);
        TextView txtSwitch1=findViewById(R.id.txt_switch_1);
        SwitchMaterial switchMaterial2=findViewById(R.id.btn_switch_2);
        TextView txtSwitch2=findViewById(R.id.txt_switch_2);
        SwitchMaterial switchMaterial3=findViewById(R.id.btn_switch_3);
        TextView txtSwitch3=findViewById(R.id.txt_switch_3);
        SwitchMaterial switchMaterial4=findViewById(R.id.btn_switch_4);
        TextView txtSwitch4=findViewById(R.id.txt_switch_4);
        SwitchMaterial switchMaterial5=findViewById(R.id.btn_switch_5);
        TextView txtSwitch5=findViewById(R.id.txt_switch_5);
        SwitchMaterial switchMaterial6=findViewById(R.id.btn_switch_6);
        TextView txtSwitch6=findViewById(R.id.txt_switch_6);
        switchMaterial5.setTrackResource(R.drawable.baseline_mic_none_24);
        switchMaterial6.setThumbTintList(ColorStateList.valueOf(Color.WHITE));


        switchMaterial6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch6.setText("Switch ON");
                    switchMaterial6.setThumbTintList(ColorStateList.valueOf(Color.CYAN));
                    switchMaterial6.setTrackTintList(ColorStateList.valueOf(0xFFE0FFFF));
                }
                else {
                    txtSwitch6.setText("Switch OFF");
                    switchMaterial6.setThumbTintList(ColorStateList.valueOf(Color.WHITE));
                    switchMaterial6.setTrackTintList(ColorStateList.valueOf(0xFFD3D3D3));

                }
            }
        });
        switchMaterial5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch5.setText("Switch ON");
                }
                else {
                    txtSwitch5.setText("Switch OFF");
                }
            }
        });
        switchMaterial4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch4.setText("Switch ON");
                }
                else {
                    txtSwitch4.setText("Switch OFF");
                }
            }
        });
        switchMaterial3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch3.setText("Switch ON");
                }
                else {
                    txtSwitch3.setText("Switch OFF");
                }
            }
        });
        switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch2.setText("Switch ON");
                }
                else {
                    txtSwitch2.setText("Switch OFF");
                }
            }
        });
        switchMaterial1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    txtSwitch1.setText("Switch ON");
                }
                else {
                    txtSwitch1.setText("Switch OFF");
                }
            }
        });

    }
}