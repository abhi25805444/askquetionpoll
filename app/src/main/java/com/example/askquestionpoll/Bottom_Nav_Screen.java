package com.example.askquestionpoll;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.fragment.app.Fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.askquestionpoll.fragment.Btm_Ui_fragment;
import com.example.askquestionpoll.fragment.Btm_bottomsheet_fragment;
import com.example.askquestionpoll.fragment.Btm_dailog_fragment;
import com.example.askquestionpoll.fragment.Btm_slider_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_Nav_Screen extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Finish the activity when back button is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView bottomNavigationView;
    private Fragment fragmentA;
    private Fragment fragmentB;
    private Fragment fragmentC;

    private Fragment fragmentD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_screen);
        setTitle("Bottom Nav Bar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragmentA = new Btm_Ui_fragment();
        fragmentB = new Btm_dailog_fragment();
        fragmentC = new Btm_bottomsheet_fragment();
        fragmentD = new Btm_slider_fragment();
        FragmentTransaction transaction = null;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager!= null)
        {
           transaction = fragmentManager.beginTransaction();
        }
        if(transaction != null)
        {
            if (fragmentA != null) {
                transaction.add(R.id.frame_layout1, fragmentA, "fragmentA");
            }
            if (fragmentB != null) {
                transaction.add(R.id.frame_layout1, fragmentB, "fragmentB");
            }
            if (fragmentC != null) {
                transaction.add(R.id.frame_layout1, fragmentC, "fragmentC");
            }
            if (fragmentD != null) {
                transaction.add(R.id.frame_layout1, fragmentD, "fragmentD");
            }
        }
      



        transaction.hide(fragmentB);
        transaction.hide(fragmentC);
        transaction.hide(fragmentD);

        transaction.commit();

        this.bottomNavigationView = findViewById(R.id.bottom_navigation);


        if (bottomNavigationView != null) {



        bottomNavigationView.setItemActiveIndicatorEnabled(false);
        this.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {


            if (item.getItemId() == R.id.item_bottom_nav_1) {
                showFragmentA();

            } else if (item.getItemId() == R.id.item_bottom_nav_2) {
                showFragmentB();
            } else if (item.getItemId() == R.id.item_bottom_nav_3) {
                showFragmentC();
            } else if (item.getItemId() == R.id.item_bottom_nav_4) {
                showFragmentD();
            }

            return true;
        });}

    }
    private void showFragmentD() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.show(fragmentD);
        transaction.hide(fragmentB);
        transaction.hide(fragmentC);
        transaction.hide(fragmentA);

        transaction.commit();
    }
    private void showFragmentA() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.show(fragmentA);
        transaction.hide(fragmentB);
        transaction.hide(fragmentC);
        transaction.hide(fragmentD);

        transaction.commit();
    }

    // Method to show Fragment B and hide other fragments
    private void showFragmentB() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.show(fragmentB);
        transaction.hide(fragmentA);
        transaction.hide(fragmentC);
        transaction.hide(fragmentD);

        transaction.commit();
    }

    // Method to show Fragment C and hide other fragments
    private void showFragmentC() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.show(fragmentC);
        transaction.hide(fragmentA);
        transaction.hide(fragmentB);
        transaction.hide(fragmentD);

        transaction.commit();
    }
}