package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;



import android.widget.Button;

public class Intentexample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentexaple);
        Button btn_open_web=findViewById(R.id.btn_open_web);
        Button btn_send_brodcast=findViewById(R.id.dail_number);
        btn_send_brodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "tel:+917434972262";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
        });
        btn_open_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }
        });
    }

}