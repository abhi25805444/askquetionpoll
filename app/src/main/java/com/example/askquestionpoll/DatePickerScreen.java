package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerScreen extends AppCompatActivity {
    Button spinnerdatepicker;
    Button dateRangepicker;
    Button calenderdatepicker;
    Button calenderdatepicker2;
    Button dailogbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_screen);
        DatePicker datePicker1=findViewById(R.id.datepicker1);
        Button btn_display_1=findViewById(R.id.display1);
        TextView txt_display1=findViewById(R.id.txtdisplay1);
        this.dailogbox=findViewById(R.id.dailod_datepicker);
         this.dateRangepicker=findViewById(R.id.dailog_rangepicker);
         this.spinnerdatepicker=findViewById(R.id.Spinner_datepicker);
         this.calenderdatepicker=findViewById(R.id.calandor_rangepicker);
        this.calenderdatepicker2=findViewById(R.id.calandor_cal2);
        calenderdatepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalendarPicker2();
            }
        });
         calenderdatepicker.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showCalendarPicker();
             }
         });

         this.dateRangepicker.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 showDateRangePicker();

             }
         });

        this.spinnerdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showspinnerDatePickerDialog();


            }
        });        btn_display_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_display1.setText(datePicker1.getDayOfMonth()+"/"+datePicker1.getMonth()+"/"+datePicker1.getYear());
                txt_display1.setVisibility(View.VISIBLE);

            }
        });
        this.dailogbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDatePickerDialog();
            }
        });
    }
    private void showDateRangePicker() {
        Calendar calendar = Calendar.getInstance();
        long today = MaterialDatePicker.todayInUtcMilliseconds();

        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        constraintsBuilder.setStart(today);
        constraintsBuilder.setEnd(MaterialDatePicker.todayInUtcMilliseconds() + 365L * 24 * 60 * 60 * 1000);

        MaterialDatePicker<Pair<Long, Long>> dateRangePicker =
                MaterialDatePicker.Builder.dateRangePicker()
                        .setTitleText("Select Date Range")
                        .setCalendarConstraints(constraintsBuilder.build())
                        .build();

        dateRangePicker.addOnPositiveButtonClickListener(
                selection -> {

                    Long startDate = ((Long) selection.first).longValue();
                    Long endDate = ((Long) selection.second).longValue();

                    String formattedStartDate = DatePickerScreen.this.convertMillisToDateString(startDate);
                    String formattedenddDate = DatePickerScreen.this.convertMillisToDateString(endDate);

                    dateRangepicker.setText(formattedStartDate+" to "+formattedenddDate);
                }
        );

        dateRangePicker.show(getSupportFragmentManager(), "date_range_picker");
    }
    private void showspinnerDatePickerDialog() {
        Calendar calendar=Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        spinnerdatepicker.setText(selectedDate);
                    }
                },
                year, month, day
        );

        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.show();
    }



    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        dailogbox.setText(selectedDate);

                    }
                },
                year, month, day
        );

        datePickerDialog.show();
    }
    private void showCalendarPicker() {
        Calendar calendar = Calendar.getInstance();
        long today = MaterialDatePicker.todayInUtcMilliseconds();

        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        constraintsBuilder.setStart(today - 365L * 24 * 60 * 60 * 1000);
        constraintsBuilder.setEnd(today + 365L * 24 * 60 * 60 * 1000);

        MaterialDatePicker<Long> datePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select a Date").setTheme(R.style.ThemeOverlay_App_MaterialCalendar)
                        .setCalendarConstraints(constraintsBuilder.build())
                        .build();


        datePicker.addOnPositiveButtonClickListener(
                selection -> {
                    Calendar selectedCalendar = Calendar.getInstance();
                    selectedCalendar.setTimeInMillis(selection);

                    int year = selectedCalendar.get(Calendar.YEAR);
                    int month = selectedCalendar.get(Calendar.MONTH);
                    int day = selectedCalendar.get(Calendar.DAY_OF_MONTH);

                    String selectedDate =  day+ "/" + (month + 1) + "/" +year ;
                    calenderdatepicker.setText(selectedDate);
                }
        );



        datePicker.show(getSupportFragmentManager(), "calendar_picker");
    }

    private void showCalendarPicker2() {
        Calendar calendar = Calendar.getInstance();
        long today = MaterialDatePicker.todayInUtcMilliseconds();

        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        constraintsBuilder.setStart(today - 365L * 24 * 60 * 60 * 1000);
        constraintsBuilder.setEnd(today + 365L * 24 * 60 * 60 * 1000);

        MaterialDatePicker<Long> datePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select a Date").setTheme(R.style.ThemeOverlay_App_MaterialCalendar2)
                        .setCalendarConstraints(constraintsBuilder.build())
                        .build();


        datePicker.addOnPositiveButtonClickListener(
                selection -> {
                    Calendar selectedCalendar = Calendar.getInstance();
                    selectedCalendar.setTimeInMillis(selection);

                    int year = selectedCalendar.get(Calendar.YEAR);
                    int month = selectedCalendar.get(Calendar.MONTH);
                    int day = selectedCalendar.get(Calendar.DAY_OF_MONTH);

                    String selectedDate =  day+ "/" + (month + 1) + "/" +year ;
                    calenderdatepicker.setText(selectedDate);
                }
        );



        datePicker.show(getSupportFragmentManager(), "calendar_picker");
    }

    public String convertMillisToDateString(long milliseconds) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(milliseconds));
    }
}