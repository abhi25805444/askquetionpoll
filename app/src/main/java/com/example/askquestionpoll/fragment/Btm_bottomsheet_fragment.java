package com.example.askquestionpoll.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.askquestionpoll.Bottom_Nav_Screen;
import com.example.askquestionpoll.R;
import com.example.askquestionpoll.bottomsheet;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class Btm_bottomsheet_fragment extends Fragment implements View.OnClickListener {



    BottomSheetBehavior mBottomSheetBehavior;
    Button stateButton;
    Button moduleButtomSheet;
    LinearLayout music;
    LinearLayout share;
    LinearLayout note;
    LinearLayout music2;
    LinearLayout share2;
    LinearLayout note2;
    LinearLayout delet;
    LinearLayout chat;
    LinearLayout email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.activity_bottomsheet, container, false);
        this.music = root.findViewById(R.id.music);
        this.share = root.findViewById(R.id.share);
        this.note = root.findViewById(R.id.note);

        this.music2 = root.findViewById(R.id.music2);
        this.share2 = root.findViewById(R.id.share2);
        this.note2 = root.findViewById(R.id.note2);


        this.delet = root.findViewById(R.id.delet);
        this.chat = root.findViewById(R.id.chat);
        this.email = root.findViewById(R.id.email);

        View bottomsheet = root.findViewById(R.id.bottom_sheet);
        this.mBottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        this.stateButton = root.findViewById(R.id.multi_btn);
        this.moduleButtomSheet = root.findViewById(R.id.model_bottom_btn);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();

            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Note", Toast.LENGTH_SHORT).show();

            }
        });

        music2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();

            }
        });
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();

            }
        });
        note2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Note", Toast.LENGTH_SHORT).show();

            }
        });


        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Delet", Toast.LENGTH_SHORT).show();

            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();

            }
        });


        moduleButtomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_model_bottom_sheet fragmentModelBottomSheet = new fragment_model_bottom_sheet();
                fragmentModelBottomSheet.show(getActivity().getSupportFragmentManager(), fragmentModelBottomSheet.getTag());
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


        return root;
    }

    @Override
    public void onClick(View view) {
        long viewId = view.getId();

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
            fragmentModelBottomSheet.show(getActivity().getSupportFragmentManager(), fragmentModelBottomSheet.getTag());
        } else if (viewId == R.id.music || viewId == R.id.music2) {
            Toast.makeText(this.getActivity(), "Music", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.share || viewId == R.id.share2) {
            Toast.makeText(this.getActivity(), "Share", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.note || viewId == R.id.note2) {
            Toast.makeText(this.getActivity(), "Note", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.delet) {
            Toast.makeText(this.getActivity(), "Delete", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.chat) {
            Toast.makeText(this.getActivity(), "Chat", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.email) {
            Toast.makeText(this.getActivity(), "Email", Toast.LENGTH_SHORT).show();
        }
    }
}