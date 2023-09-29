package com.example.askquestionpoll;


import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.MotionEffect;

import com.example.askquestionpoll.Helper.DaynamicSticker;

public class DragLayout extends AppCompatActivity {
    boolean isRelToched = false;
    RelativeLayout relativeLayout;
    EditText editText;
    ImageView imageView;
    Long LastTouchTime;
    DaynamicSticker dynamicLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_drag_layout, null);
        setContentView(rootView);
        relativeLayout = new RelativeLayout(this);
        editText = new EditText(this);
        imageView = new ImageView(this);
        dynamicLayout = new DaynamicSticker(this, relativeLayout, editText, imageView);
        editText.setLongClickable(false);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Editext is toached");
                        long unused = LastTouchTime = System.currentTimeMillis();
                        isRelToched = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        long delayTime = System.currentTimeMillis() - LastTouchTime;
                        Log.d(MotionEffect.TAG, "onTouch: " + delayTime);
                        if (delayTime < 300) {
                            editText.requestFocus();
                            dynamicLayout.showKeybard(editText);
                            return false;
                        }
                        dynamicLayout.hideKeyboard(editText);
                        return true;
                    default:
                        return true;
                }
            }
        });
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isRelToched = true;
                return false;
            }
        });
        rootView.addView(relativeLayout);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "Activity class onTouchEvent: ");
        return super.onTouchEvent(event);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, " Activity dispatchTouchEvent: " + super.dispatchTouchEvent(event));
        super.dispatchTouchEvent(event);
        if (isRelToched) {
            dynamicLayout.dispatchTouchEvent(event);

            float rawX = event.getRawX();
            float rawY = event.getRawY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    isRelToched = false;
                    return true;
                default:
                    return true;
            }
        } else {
            return true;
        }
    }

}