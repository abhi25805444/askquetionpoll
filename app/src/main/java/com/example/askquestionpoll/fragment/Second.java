package com.example.askquestionpoll.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.askquestionpoll.R;
import com.example.askquestionpoll.activity.Activity2;


public class Second extends Fragment {
    @Override
    public void onPause() {
        getActivity().finish();
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        TextView txt_Previous_is = rootView.findViewById(R.id.txt_previous_is);
        String fragment = requireArguments().getString("Fraagment");
        txt_Previous_is.setText("previous is " + fragment);
        Button btn_First_Activity = rootView.findViewById(R.id.btn_first_activity);
        btn_First_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), Activity2.class);
                i.putExtra("Fragment", "Fragment 2");
                startActivity(i);


            }
        });
        return rootView;
    }
}