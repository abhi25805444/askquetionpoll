package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.askquestionpoll.activity.Activity1;
import com.example.askquestionpoll.activity.CameraActivity;
import com.example.askquestionpoll.activity.Programtic_layout;
import com.example.askquestionpoll.fragment.collaps;
import com.example.askquestionpoll.fragment.collapsing_toolbar;

public class MainActivity extends AppCompatActivity implements interfacefordemo {

    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_layout=findViewById(R.id.btn_programatic_layout);
        Button btn_activity_frag = findViewById(R.id.btn_activity_fragment);
        Button btn_camera = findViewById(R.id.btn_camera);
        Button btn_ui = findViewById(R.id.btn_ui1);
        Button btn_ui2 = findViewById(R.id.btn_ui2);
        Button btn_interface_demo = findViewById(R.id.btn_interface_demo);
        Button btn_button_screen = findViewById(R.id.btn_screen);
        Button btn_image_screen = findViewById(R.id.btn_image_screen);
        Button btn_edittext_screen = findViewById(R.id.btn_edittext_screen);
        Button btn_checkbox_screen=findViewById(R.id.btn_checkbox_screen);
        Button btn_radio_screen=findViewById(R.id.btn_radiou_screen);
        Button btn_switch_screen=findViewById(R.id.btn_switch_screen);
        Button btn_rating_screen=findViewById(R.id.btn_rating_screen);
        Button btn_spinner_screen=findViewById(R.id.btn_spinner_screen);
        Button btn_datepicker_screen=findViewById(R.id.btn_datepicker_screen);
        Button btn_time_picker=findViewById(R.id.btn_time_screen);
        Button btn_toast=findViewById(R.id.btn_toast_screen);
        Button btn_snackbar=findViewById(R.id.btn_snackbar_screen);
        Button btn_seekbar=findViewById(R.id.btn_seeekbar_screen);
        Button btn_cradview=findViewById(R.id.btn_cardview_screen);
        Button btn_dailog=findViewById(R.id.btn_dailog_screen);
        Button btn_btm_nav=findViewById(R.id.btn_bottom_navi_screen);
        Button btn_collaps_toolbar=findViewById(R.id.btn_collapstoolbar_screen);
        Button btn_animation=findViewById(R.id.btn_animation_screen);
        Button btn_recycleview=findViewById(R.id.btn_recycleview_screen);
        Button btn_Draglayout=findViewById(R.id.btn_DragLayout);
        btn_Draglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), DragLayout.class);
                startActivity(i);
            }
        });
        btn_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), Programtic_layout.class);
                startActivity(i);
            }
        });
        btn_recycleview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), RecycleView_Screen.class);
                startActivity(i);
            }
        });
        btn_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), Animation_Screen.class);
                startActivity(i);
            }
        });
        btn_collaps_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), ScrollingActivity.class);
                startActivity(i);
            }
        });
        btn_btm_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), Bottom_Nav_Screen.class);
                startActivity(i);
            }
        });
        btn_dailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),dailogScreen.class);
                startActivity(i);
            }
        });

        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),snackbarActvity.class);
                startActivity(i);
            }
        });

        btn_cradview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),cardView.class);
                startActivity(i);
            }
        });

        btn_seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),seekBarActivity.class);
                startActivity(i);
            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ToastActivity.class);
                startActivity(i);
            }
        });

        btn_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),TimerPickerScreeen.class);
                startActivity(i);
            }
        });

        btn_datepicker_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DatePickerScreen.class);
                startActivity(i);
            }
        });
        btn_spinner_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), SpinnerActivity.class);
                startActivity(i);
            }
        });
        btn_rating_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),RatingActivity.class);
                startActivity(i);
            }
        });
        btn_switch_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SwitchActivity.class);
                startActivity(i);
            }
        });
        btn_radio_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),RadiobuttonsActivity.class);
                startActivity(i);
            }
        });
        btn_checkbox_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),CheckboxActivity.class);
                startActivity(i);
            }
        });
        btn_edittext_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),EditextActivity.class);
                startActivity(i);
            }
        });
        btn_image_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ImagesActivity.class);
                startActivity(i);
            }
        });

        btn_button_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ButtonsActivity.class);
                startActivity(i);
            }
        });


        interfacedemo.setDataPassListener(this);

        textView = findViewById(R.id.txt);
        btn_interface_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), interfacedemo.class);
                startActivity(intent);
            }
        });
        btn_ui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Module4_Screen2.class);
                startActivity(intent);
            }
        });
        btn_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Module4_Screen1.class);
                startActivity(intent);
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
            }
        });
        btn_activity_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onsend(String s) {
        textView.setText(s);
    }
}