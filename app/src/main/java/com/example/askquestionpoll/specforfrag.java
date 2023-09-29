package com.example.askquestionpoll;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.askquestionpoll.fragment.Btm_Ui_fragment;
import com.example.askquestionpoll.fragment.Btm_dailog_fragment;

public class specforfrag extends AppCompatActivity {
    private Fragment fragmentA;
    private Fragment fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specforfrag);
        fragmentA = new Btm_Ui_fragment();
        fragmentB = new Btm_dailog_fragment();

        Button button =findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragmentB();
            }
        });


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.frame_layout, fragmentA, "fragmentA");
        transaction.add(R.id.frame_layout, fragmentB, "fragmentB");

        transaction.hide(fragmentB); // Hide Fragment B initially
        transaction.commit();
    }
    private void showFragmentB() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.show(fragmentB);
        transaction.hide(fragmentA);

        transaction.commit();
    }
}