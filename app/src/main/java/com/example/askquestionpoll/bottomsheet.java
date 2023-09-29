package com.example.askquestionpoll;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.askquestionpoll.fragment.fragment_model_bottom_sheet;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class bottomsheet extends AppCompatActivity implements View.OnClickListener {

    BottomSheetBehavior mBottomSheetBehavior;
    Button stateButton;
    Button moduleButtomSheet;
    LinearLayout music;
    LinearLayout share;
    LinearLayout note;
    LinearLayout music2;
    LinearLayout share2;
    LinearLayout note2;
    LinearLayout delet ;
    LinearLayout chat ;
    LinearLayout email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheet);

        this.music = findViewById(R.id.music);
        this.share = findViewById(R.id.share);
        this.note = findViewById(R.id.note);

        this.music2 = findViewById(R.id.music2);
        this.share2 = findViewById(R.id.share2);
        this.note2 = findViewById(R.id.note2);


        this.delet = findViewById(R.id.delet);
        this.chat = findViewById(R.id.chat);
        this.email = findViewById(R.id.email);


        View bottomsheet = findViewById(R.id.bottom_sheet);
        this.mBottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        this.stateButton = findViewById(R.id.multi_btn);
        this.moduleButtomSheet = findViewById(R.id.model_bottom_btn);
        moduleButtomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_model_bottom_sheet fragmentModelBottomSheet = new fragment_model_bottom_sheet();
                fragmentModelBottomSheet.show(getSupportFragmentManager(), fragmentModelBottomSheet.getTag());
            }
        });


        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateButton.getText().toString().equals("BOTTOM SHEET")) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                if (stateButton.getText().toString() == "Hidden") {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                if (stateButton.getText().toString() == "Expanded") {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                if (stateButton.getText().toString() == "Collspsed") {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }


            }
        });

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (mBottomSheetBehavior.STATE_EXPANDED == newState) {
                    stateButton.setText("Expanded");

                }
                if (mBottomSheetBehavior.STATE_HIDDEN == newState) {
                    stateButton.setText("Hidden");

                }
                if (mBottomSheetBehavior.STATE_DRAGGING == newState) {
                    stateButton.setText("Dragging");

                }
                if (mBottomSheetBehavior.STATE_COLLAPSED == newState) {
                    stateButton.setText("Collspsed");

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


    }
    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.multi_btn) {
            if ("BOTTOM SHEET".equals(stateButton.getText().toString())) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            } else if ("Hidden".equals(stateButton.getText().toString())) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else if ("Expanded".equals(stateButton.getText().toString())) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else if ("Collspsed".equals(stateButton.getText().toString())) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        } else if (viewId == R.id.model_bottom_btn) {
            fragment_model_bottom_sheet fragmentModelBottomSheet = new fragment_model_bottom_sheet();
            fragmentModelBottomSheet.show(getSupportFragmentManager(), fragmentModelBottomSheet.getTag());
        } else if (viewId == R.id.music || viewId == R.id.music2) {
            Toast.makeText(getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.share || viewId == R.id.share2) {
            Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.note || viewId == R.id.note2) {
            Toast.makeText(getApplicationContext(), "Note", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.delet) {
            Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.chat) {
            Toast.makeText(getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.email) {
            Toast.makeText(getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onBackPressed() {
        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            super.onBackPressed();
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }
}