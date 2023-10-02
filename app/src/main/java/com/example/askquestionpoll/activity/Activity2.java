package com.example.askquestionpoll.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.askquestionpoll.R;


public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        TextView textView = findViewById(R.id.txt_acticity_name);
        Intent i = getIntent();
        String Activity = i.getStringExtra("activity");
        Intent intent = getIntent();
        String return1 = intent.getStringExtra("Fragm");
        if (return1 != null) {
            textView.setText("previous activity is " + return1);
        } else {
            textView.setText("previous activity is " +Activity);
        }


    }
}