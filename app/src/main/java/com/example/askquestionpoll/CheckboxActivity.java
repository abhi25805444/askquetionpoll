package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_checkbox);
        CheckBox reading=findViewById(R.id.reading_checkbox);
        CheckBox carromcheckbox=findViewById(R.id.caroom_chekbox);
        CheckBox writingcheckBox=findViewById(R.id.writing);
        CheckBox baskeballcheckBox=findViewById(R.id.basketballcheckbox);
        CheckBox dance=findViewById(R.id.dancecheckbox);
        CheckBox Android=findViewById(R.id.android);
        CheckBox web=findViewById(R.id.web);
        CheckBox php=findViewById(R.id.php);
        Button button=findViewById(R.id.btn_display);
        TextView resulttxt=findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display="";
                if(reading.isChecked())
                {
                    display=display+reading.getText().toString()+"\n";
                }
                if(carromcheckbox.isChecked())
                {
                    display=display+carromcheckbox.getText().toString()+"\n";
                }
                if(writingcheckBox.isChecked())
                {
                    display=display+writingcheckBox.getText().toString()+"\n";
                }
                if(baskeballcheckBox.isChecked())
                {
                    display=display+baskeballcheckBox.getText().toString()+"\n";
                }
                if(dance.isChecked())
                {
                    display=display+dance.getText().toString()+"\n";
                }
                if(Android.isChecked())
                {
                    display=display+Android.getText().toString()+"\n";
                }
                if(web.isChecked())
                {
                    display=display+web.getText().toString()+"\n";
                }
                if(php.isChecked())
                {
                    display=display+php.getText().toString()+"\n";
                }
                resulttxt.setText(display);

            }
        });
        php.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {

                    php.setTextColor(Color.BLUE);
                    if(web.isChecked()||Android.isChecked())
                    {
                        web.setChecked(false);
                        Android.setChecked(false);
                    }
                }
                else
                {
                    php.setTextColor(Color.RED);
                }
            }
        });

        web.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    web.setTextColor(Color.BLUE);
                    if(Android.isChecked()||php.isChecked())
                    {
                        Android.setChecked(false);
                        php.setChecked(false);
                    }
                }
                else {
                    web.setTextColor(Color.RED);
                }
            }
        });

        Android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Android.setTextColor(Color.BLUE);
                    if(web.isChecked()||php.isChecked())
                    {
                        web.setChecked(false);
                        php.setChecked(false);
                    }
                }else
                {
                    Android.setTextColor(Color.RED);
                }
            }
        });

        dance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    dance.setTextColor(Color.BLUE);
                }
                else {
                    dance.setTextColor(Color.RED);
                }
            }
        });
       baskeballcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b)
               {
                   baskeballcheckBox.setTextColor(Color.BLUE);
               }else {
                   baskeballcheckBox.setTextColor(Color.RED);
               }
           }
       });
       writingcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b)
               {
                   writingcheckBox.setTextColor(Color.BLUE);
               }else {
                   writingcheckBox.setTextColor(Color.RED);
               }
           }
       });
        carromcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    carromcheckbox.setTextColor(Color.BLUE);
                }else {
                    carromcheckbox.setTextColor(Color.RED);
                }
            }
        });
    }
}