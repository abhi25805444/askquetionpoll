package com.example.askquestionpoll.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.askquestionpoll.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class fragment_model_bottom_sheet extends BottomSheetDialogFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_model_bottom_sheet, container, false);
        LinearLayout music=root.findViewById(R.id.music);
        LinearLayout share=root.findViewById(R.id.share);
        LinearLayout note=root.findViewById(R.id.note);
        Button close_btn=root.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Note", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        LinearLayout music2=root.findViewById(R.id.music2);
        LinearLayout share2=root.findViewById(R.id.share2);
        LinearLayout note2=root.findViewById(R.id.note2);
        note2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Note", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        music2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });

        LinearLayout delet=root.findViewById(R.id.delet);
        LinearLayout chat=root.findViewById(R.id.chat);
        LinearLayout email=root.findViewById(R.id.email);
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();
                fragment_model_bottom_sheet.this.dismiss();
            }
        });

        return root;
    }
}