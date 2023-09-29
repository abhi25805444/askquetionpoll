package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        Button btn_simple=findViewById(R.id.btn_simple);
        Button btn_left_icon=findViewById(R.id.btn_lef_icon_button);
        Button btn_right_icon=findViewById(R.id.btn_right_icon_button);
        Button btn_image=findViewById(R.id.btn_image);
        Button btn_with_border=findViewById(R.id.btn_with_border_button);
        Button btn_with_radious=findViewById(R.id.btn_with_border_radious_button);
        Button btn_rounded_button=findViewById(R.id.btn_rounded_button);
        Button btn_shadow_with_rippel_button=findViewById(R.id.btn_shadow_with_ripple);
        Button btn_txt=findViewById(R.id.txtbtn);
        Button btn_with_corner=findViewById(R.id.corner_btn);
        Button btn_with_shadow=findViewById(R.id.btn_shadow);
        Button btn_ripple=findViewById(R.id.btn_ripple);
        btn_ripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Ripple Color",Toast.LENGTH_SHORT).show();
            }
        });
        btn_with_shadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Shdow",Toast.LENGTH_SHORT).show();
            }
        });
        btn_with_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Corner",Toast.LENGTH_SHORT).show();
            }
        });
        btn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Text Button",Toast.LENGTH_SHORT).show();
            }
        });
        btn_shadow_with_rippel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_shadow_with_rippel_button.setElevation(10);
                btn_shadow_with_rippel_button.setShadowLayer(10,2,3,R.color.black);
                Toast.makeText(getApplicationContext(),"Button With Shadow and Ripple",Toast.LENGTH_SHORT).show();
            }
        });
        btn_rounded_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Rounded Button",Toast.LENGTH_SHORT).show();
            }
        });
        btn_with_radious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Border Radious",Toast.LENGTH_SHORT).show();
            }
        });
        btn_with_border.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Border Color",Toast.LENGTH_SHORT).show();
            }
        });
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Background Image",Toast.LENGTH_SHORT).show();
            }
        });
        btn_right_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Right Icon",Toast.LENGTH_SHORT).show();
            }
        });
        btn_left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button With Left Icon",Toast.LENGTH_SHORT).show();
            }
        });
        btn_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simple Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}