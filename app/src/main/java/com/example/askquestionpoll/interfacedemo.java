package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class interfacedemo extends AppCompatActivity {
    private static final String TAG = "interfacedemo";

    private static interfacefordemo interfacefordemo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interfacedemo);
        Button button = findViewById(R.id.goiback);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, " >>> onClick <<< ");
                if (interfacefordemo1 != null) {
                    String data = "hellodsfgsdgh dsfh";
                    interfacefordemo1.onsend(data);
                    finish();
                } else {
                    Log.i(TAG, "onClick: interfacefordemo1 is getting null");
                }

            }
        });

    }

    public static void setDataPassListener(interfacefordemo interfacefordemo) {
        interfacefordemo1 = interfacefordemo;
    }
}