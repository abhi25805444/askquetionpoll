package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class snackbarActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar_actvity);

        Button btn_dafault_snackbar=findViewById(R.id.default_snackbar);
        Button btn_event_snackbar=findViewById(R.id.event_snackbar);
        Button custom_snackbar=findViewById(R.id.custom_snackbar);

        custom_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, (CharSequence) "Try Again..!!", BaseTransientBottomBar.LENGTH_INDEFINITE);
                View snackbarView = snackbar.getView();
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbarView.getLayoutParams();
                params.gravity = 17;
                snackbarView.setLayoutParams(params);
                snackbar.setBackgroundTint(ContextCompat.getColor(snackbarActvity.this, R.color.black));
                snackbar.setActionTextColor(Color.parseColor("#AFEC69"));
                snackbar.setAction((CharSequence) "DISMISS", (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });
        btn_event_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, (CharSequence) "Hey..Click me!!",BaseTransientBottomBar.LENGTH_INDEFINITE);
                snackbar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.black));
                snackbar.setActionTextColor(Color.parseColor("#FF5722"));
                snackbar.setAction("Dissmis", (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();

            }
        });
        btn_dafault_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(view,"Hello..!Default Snackbar Example",Snackbar.LENGTH_LONG).show();
            }
        });

    }
}