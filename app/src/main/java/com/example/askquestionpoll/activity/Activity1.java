package com.example.askquestionpoll.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.askquestionpoll.R;
import com.example.askquestionpoll.fragment.First;


public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        String activity="Activity1";
        TextView textView=findViewById(R.id.txt_acticity_name);
        Button btnNextActivity=findViewById(R.id.btn_next_activity);
        Button btnNextFragment=findViewById(R.id.btn_next_fragment);
        textView.setText("activity is "+activity);


        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("activity",activity);
                Fragment fragment=new First();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_activity1,fragment).commit();
                fragment.setArguments(b);
            }
        });
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Activity2.class);
                i.putExtra("activity",activity);
                startActivity(i);
            }
        });
    }
}