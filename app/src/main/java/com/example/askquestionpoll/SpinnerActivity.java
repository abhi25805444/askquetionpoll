package com.example.askquestionpoll;

import static java.lang.Math.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    String Country="";
    String State="";
    String City="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Spinner spinner1 = findViewById(R.id.sp1);
        Spinner spinnerContry = findViewById(R.id.sp2);
        Spinner spinnerState = findViewById(R.id.sp3);
        Spinner SpinnercityState = findViewById(R.id.sp4);
        TextView txt_iteams = findViewById(R.id.selected_items_txt);

        ArrayList<String>arrayList=new ArrayList<String>();


        final String[] items = getResources().getStringArray(R.array.spinner1);
        final String[] contries = getResources().getStringArray(R.array.country);
        final String[] india_state = getResources().getStringArray(R.array.india_state);
        final String[] aus_state = getResources().getStringArray(R.array.aus_state);
        final String[] gujarat_city = getResources().getStringArray(R.array.gujarat_city);
        final String[] bihar_city = getResources().getStringArray(R.array.bihar_city);
        final String[] South_Australia_city = getResources().getStringArray(R.array.southaustralia_city);
        final String[] Queensland_city = getResources().getStringArray(R.array.queensland_city);


        TextView d1 = findViewById(R.id.diveder1);



        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner1, R.layout.custom_spinner);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner);
        spinner1.setAdapter(arrayAdapter);

        ArrayAdapter<CharSequence> ContryArrayAdapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        ContryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerContry.setAdapter(ContryArrayAdapter);

        ArrayAdapter<CharSequence> indiaStateArrayAdapter = ArrayAdapter.createFromResource(this, R.array.india_state, android.R.layout.simple_spinner_item);
        indiaStateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> ausStateArrayAdapter = ArrayAdapter.createFromResource(this, R.array.aus_state, android.R.layout.simple_spinner_item);
        ausStateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(indiaStateArrayAdapter);


        ArrayAdapter<CharSequence> BiharStateArrayAdapter = ArrayAdapter.createFromResource(this, R.array.bihar_city, android.R.layout.simple_spinner_item);
        BiharStateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> QueenslandStateArrayAdapter = ArrayAdapter.createFromResource(this, R.array.queensland_city, android.R.layout.simple_spinner_item);
        QueenslandStateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        ArrayAdapter<CharSequence> GujaratStateArrayAdapter = ArrayAdapter.createFromResource(this, R.array.gujarat_city, android.R.layout.simple_spinner_item);
        GujaratStateArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> SouthAustraliArrayAdapter = ArrayAdapter.createFromResource(this, R.array.southaustralia_city, android.R.layout.simple_spinner_item);
        SouthAustraliArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                txt_iteams.setText("You Selected : " + items[position]);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerContry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (contries[position].equals(contries[1])) {


                    spinnerState.setAdapter(ausStateArrayAdapter);
                    contryCal(contries[position]);
                }
                if (contries[position].equals(contries[0])) {

                    spinnerState.setAdapter(indiaStateArrayAdapter);
                    contryCal(contries[position]);
                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (spinnerState.getAdapter() == indiaStateArrayAdapter) {
                    if (india_state[position].equals(india_state[0])) {

                        SpinnercityState.setAdapter(GujaratStateArrayAdapter);
                        stateCal(india_state[position]);
                    } else {

                        SpinnercityState.setAdapter(BiharStateArrayAdapter);
                        stateCal(india_state[position]);
                    }
                }
                if (spinnerState.getAdapter() == ausStateArrayAdapter) {
                    if (aus_state[position].equals(aus_state[position])) {

                        SpinnercityState.setAdapter(QueenslandStateArrayAdapter);
                        stateCal(aus_state[position]);
                    }
                    if (aus_state[position].equals("SouthAustralia")) {

                        SpinnercityState.setAdapter(SouthAustraliArrayAdapter);
                        stateCal(aus_state[position]);
                    }

                }


            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        SpinnercityState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if(SpinnercityState.getAdapter() == GujaratStateArrayAdapter)
                {
                    if(gujarat_city[position].equals(gujarat_city[0]))
                    {

                        cityCal(gujarat_city[position]);
                    }
                    else{

                        cityCal(gujarat_city[position]);
                    }
                }
                if(SpinnercityState.getAdapter() == BiharStateArrayAdapter)
                {
                    if(bihar_city[position].equals(bihar_city[0]))
                    {

                        cityCal(bihar_city[position]);
                    }
                    else{

                        cityCal(bihar_city[position]);
                    }
                }
                if(SpinnercityState.getAdapter() == QueenslandStateArrayAdapter)
                {
                    if(Queensland_city[position].equals(Queensland_city[0]))
                    {

                        cityCal(Queensland_city[position]);
                    }
                    else{

                        cityCal(Queensland_city[position]);
                    }
                }
                if(SpinnercityState.getAdapter() == SouthAustraliArrayAdapter)
                {
                    if(South_Australia_city[position].equals(South_Australia_city[0]))
                    {

                        cityCal(South_Australia_city[position]);
                    }
                    else{
                        cityCal(South_Australia_city[position]);
                    }
                }
            }


            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });




        Button button = findViewById(R.id.display_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(arrayList.toString());

                d1.setText(Country+" > "+State+" > "+City);
                d1.setVisibility(View.VISIBLE);

            }
        });


    }
    public void contryCal(String s)
    {
        Country=s;

    }
    public void stateCal(String s)
    {
        State=s;

    }
    public void cityCal(String s)
    {
        City=s;

    }
}