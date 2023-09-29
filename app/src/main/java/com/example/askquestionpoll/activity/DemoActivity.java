package com.example.askquestionpoll.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.askquestionpoll.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DemoActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
    }
}
