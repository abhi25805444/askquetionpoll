package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimerPickerScreeen extends AppCompatActivity {

    Button timedailog;
    Button btn24timedailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_picker_screeen);
        TimePicker timePicker1=findViewById(R.id.time1);
        Button btn_Display=findViewById(R.id.btn_display);
        TextView txt1=findViewById(R.id.txt1);
        this.timedailog=findViewById(R.id.btn2);
        this.btn24timedailog=findViewById(R.id.btn3);
        this.btn24timedailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show24HoursTimeDialog();

            }

        });
        this.timedailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }

        });
        btn_Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText("Current Time: "+timePicker1.getHour()+" : "+timePicker1.getMinute());
                txt1.setVisibility(View.VISIBLE);

            }
        });
    }
    private void showTimePickerDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,R.style.timepickertheme,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        Calendar selectedTime = Calendar.getInstance();
                        selectedTime.set(Calendar.HOUR_OF_DAY, selectedHour);
                        selectedTime.set(Calendar.MINUTE, selectedMinute);

                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                        String formattedTime = sdf.format(selectedTime.getTime());

                        timedailog.setText(formattedTime);
                    }
                },
                hour, minute, false);

        timePickerDialog.show();
    }
    private void show24HoursTimeDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {

                        String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                        btn24timedailog.setText(formattedTime);

                    }
                },
                hour, minute, true
        );

        timePickerDialog.show();
    }
}
