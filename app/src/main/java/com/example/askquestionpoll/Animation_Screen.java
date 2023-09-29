package com.example.askquestionpoll;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Animation_Screen extends AppCompatActivity {

    Animation fadeInAnimation;
    Animation fadeOutAnimation;
    Animation blinkAnimation;

    Animation zoomInAnimation;
    Animation zoomOutAnimation;

    Animation rotateAnimation;

    Animation moveAnimation;
    Animation slideUpAnimation;

    Animation slideDownAnimation;
    Animation sequentialAnimation;

    Animation bounceAnimation;
    Animation togethereAnimation;
    TextView txtTogether;
    TextView txtSequentialAnimation;
    TextView txtSlideUp;

    TextView txtBounce;

    TextView txtSlideDown;
    TextView txtMove;
    TextView txtRotate;
    TextView txtZoomOut;
    TextView txtZoomin;
    TextView txtFadeIn;
    TextView txtFadeout;
    TextView txtBlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_screen);
        this.txtFadeIn = findViewById(R.id.txt_fade_in);
        this.txtFadeout = findViewById(R.id.txt_fade_out);
        this.txtBlink=findViewById(R.id.txt_blink);
        this.txtZoomin=findViewById(R.id.txt_zoom_in);
        this.txtZoomOut=findViewById(R.id.txt_zoom_out);
        this.txtRotate=findViewById(R.id.txt_routet);
        this.txtSlideUp=findViewById(R.id.txt_slideup);
        this.txtMove=findViewById(R.id.txt_move);
        this.txtSlideDown=findViewById(R.id.txt_slidedown);
        this.txtBounce=findViewById(R.id.txt_bounce);
        this.txtTogether=findViewById(R.id.txt_together);
        this.txtSequentialAnimation=findViewById(R.id.txt_sequentialanimation);
        this.togethereAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);
        this.sequentialAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequential_animation);
        this.bounceAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        this.slideDownAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        this.slideUpAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        this.moveAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        this.rotateAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        this.zoomOutAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        this.zoomInAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        this.blinkAnimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        this.fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        this.fadeOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        txtTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTogether.startAnimation(togethereAnimation);
            }
        });

        txtSequentialAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSequentialAnimation.startAnimation(sequentialAnimation);
            }
        });

        txtBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBounce.startAnimation(bounceAnimation);
            }
        });

        txtSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSlideDown.startAnimation(slideDownAnimation);
            }
        });

        txtSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                txtSlideUp.startAnimation(slideUpAnimation);
            }
        });

        txtMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMove.startAnimation(moveAnimation);
            }
        });

        txtRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRotate.startAnimation(rotateAnimation);
            }
        });

        txtZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtZoomOut.startAnimation(zoomOutAnimation);
            }
        });

        txtZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtZoomin.startAnimation(zoomInAnimation);
            }
        });

        txtBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBlink.startAnimation(blinkAnimation);
            }
        });

        txtFadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtFadeout.startAnimation(fadeOutAnimation);
            }
        });

        txtFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtFadeIn.startAnimation(fadeInAnimation);
            }
        });


    }
}