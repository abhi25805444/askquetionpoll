package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button btn_simple=findViewById(R.id.simple_toast);
        Button btn_custom=findViewById(R.id.custom_toast);
        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View toastLayout = ToastActivity.this.getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) null);
                TextView toastMessage = (TextView) toastLayout.findViewById(R.id.toast_text);
                toastMessage.setTextSize(20.0f);
                toastMessage.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_bookmark_24, 0, 0, 0);
                toastMessage.setCompoundDrawablePadding(15);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(17, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastLayout);
                toast.show();

            }
        });
        btn_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"This Is Simple Toast",Toast.LENGTH_LONG).show();

            }
        });
    }
}