package com.example.askquestionpoll.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.askquestionpoll.Bottom_Nav_Screen;
import com.example.askquestionpoll.ButtonsActivity;
import com.example.askquestionpoll.CheckboxActivity;
import com.example.askquestionpoll.DatePickerScreen;
import com.example.askquestionpoll.EditextActivity;
import com.example.askquestionpoll.ImagesActivity;
import com.example.askquestionpoll.R;
import com.example.askquestionpoll.RadiobuttonsActivity;
import com.example.askquestionpoll.RatingActivity;
import com.example.askquestionpoll.SpinnerActivity;
import com.example.askquestionpoll.SwitchActivity;
import com.example.askquestionpoll.TimerPickerScreeen;
import com.example.askquestionpoll.ToastActivity;
import com.example.askquestionpoll.cardView;
import com.example.askquestionpoll.dailogScreen;
import com.example.askquestionpoll.seekBarActivity;
import com.example.askquestionpoll.snackbarActvity;

public class Btm_Ui_fragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_btm__ui_fragment, container, false);
        Button btn_button_screen = root.findViewById(R.id.btn_screen);
        Button btn_image_screen = root.findViewById(R.id.btn_image_screen);
        Button btn_edittext_screen = root.findViewById(R.id.btn_edittext_screen);
        Button btn_checkbox_screen=root.findViewById(R.id.btn_checkbox_screen);
        Button btn_radio_screen=root.findViewById(R.id.btn_radiou_screen);
        Button btn_switch_screen=root.findViewById(R.id.btn_switch_screen);
        Button btn_rating_screen=root.findViewById(R.id.btn_rating_screen);
        Button btn_spinner_screen=root.findViewById(R.id.btn_spinner_screen);
        Button btn_datepicker_screen=root.findViewById(R.id.btn_datepicker_screen);
        Button btn_time_picker=root.findViewById(R.id.btn_time_screen);
        Button btn_toast=root.findViewById(R.id.btn_toast_screen);
        Button btn_snackbar=root.findViewById(R.id.btn_snackbar_screen);
        Button btn_seekbar=root.findViewById(R.id.btn_seeekbar_screen);
        Button btn_cradview=root.findViewById(R.id.btn_cardview_screen);
        Button btn_dailog=root.findViewById(R.id.btn_dailog_screen);
        Button btn_btm_nav=root.findViewById(R.id.btn_bottom_navi_screen);
        btn_btm_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), Bottom_Nav_Screen.class);
                startActivity(i);
            }
        });
        btn_dailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), dailogScreen.class);
                startActivity(i);
            }
        });

        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), snackbarActvity.class);
                startActivity(i);
            }
        });

        btn_cradview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), cardView.class);
                startActivity(i);
            }
        });

        btn_seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), seekBarActivity.class);
                startActivity(i);
            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), ToastActivity.class);
                startActivity(i);
            }
        });

        btn_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), TimerPickerScreeen.class);
                startActivity(i);
            }
        });

        btn_datepicker_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), DatePickerScreen.class);
                startActivity(i);
            }
        });
        btn_spinner_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), SpinnerActivity.class);
                startActivity(i);
            }
        });
        btn_rating_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), RatingActivity.class);
                startActivity(i);
            }
        });
        btn_switch_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), SwitchActivity.class);
                startActivity(i);
            }
        });
        btn_radio_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), RadiobuttonsActivity.class);
                startActivity(i);
            }
        });
        btn_checkbox_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), CheckboxActivity.class);
                startActivity(i);
            }
        });
        btn_edittext_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), EditextActivity.class);
                startActivity(i);
            }
        });
        btn_image_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), ImagesActivity.class);
                startActivity(i);
            }
        });

        btn_button_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(), ButtonsActivity.class);
                startActivity(i);
            }
        });
        return root;
    }
}