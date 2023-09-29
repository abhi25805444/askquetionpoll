package com.example.askquestionpoll.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.askquestionpoll.R;


public class First extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_first, container, false);
        Button btn_Next_Fragment=rootView.findViewById(R.id.btn_next_fragment);
        TextView txtPrevious_is=rootView.findViewById(R.id.txt_previous_is);
        String activity=requireArguments().getString("activity");
        txtPrevious_is.setText("Previous is "+activity);
        btn_Next_Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment=new Second();
                Bundle bundle=new Bundle();
                String fragment1="Fragment 1";
                bundle.putString("Fraagment",fragment1.toString());
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.first_fragment,fragment).commit();
            }
        });
        return rootView;
    }
}