package com.example.askquestionpoll.Helper;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.constraintlayout.helper.widget.MotionEffect;

import com.example.askquestionpoll.R;

public class DaynamicSticker extends RelativeLayout {
    Context context;
    Activity activity;
    boolean isRelToched = false;
    EditText editText;
    ImageView imageView;
    int CurrentHeight;
    int CurrebtWidth;
    int prevline = 1;
    int line = 1;
    int CurrentHeightofImage;
    int CurrentHeightofEditdtext;
    RelativeLayout.LayoutParams imageParams;
    RelativeLayout.LayoutParams editTextParams;
    RelativeLayout relativeLayout;
    private float motionEventX;
    private float motionEventY;
    private float relLayoutX;
    Long LastTouchTime;
    private float relLayoutY;

    public DaynamicSticker(Context context,RelativeLayout relativeLayout,EditText editText,ImageView imageView) {
        super(context);
        this.imageView=imageView;
        this.editText=editText;
        this.relativeLayout=relativeLayout;
        loadLayout();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, " calss dispatchTouchEvent: "+super.dispatchTouchEvent(event));
        super.dispatchTouchEvent(event);
        Log.d(TAG, "is Relized Toch" + isRelToched);
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                motionEventX = rawX;
                motionEventY = rawY;
                Log.d(TAG, "on event start rawX down is" + motionEventX);
                Log.d(TAG, "on event end rawY down is" + motionEventY);
                relLayoutX = relativeLayout.getX();
                relLayoutY = relativeLayout.getY();
                Log.d(TAG, "on event start rel rawX" + relLayoutX);
                Log.d(TAG, "on event start rel rawY" + relLayoutY);
                return true;
            case MotionEvent.ACTION_MOVE:
                hideKeyboard(editText);
                float firstRelX = relLayoutX;
                float firstRely = relLayoutY;
                float halfWidthofRel = (float) (relativeLayout.getWidth() / 2);
                float halfHeightofRel = (float) (relativeLayout.getHeight() / 2);
                ViewGroup parentView = (ViewGroup) relativeLayout.getParent();
                float updatedX = Math.max(-halfWidthofRel, Math.min(firstRelX + (rawX - motionEventX), ((float) parentView.getWidth()) - halfWidthofRel));
                float updatedY = Math.max(-halfHeightofRel, Math.min(firstRely + (rawY - motionEventY), ((float) parentView.getHeight()) - halfHeightofRel));
                relativeLayout.setX(updatedX);
                relativeLayout.setY(updatedY);
                return true;
            case MotionEvent.ACTION_UP:
                isRelToched = false;
                return true;
            default:
                return true;
        }

    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.d(TAG, "onInterceptTouchEvent: "+super.onInterceptTouchEvent(event));
        return true;
    }

    public void loadLayout()
    {
        Log.d(TAG, "loadLayout: is called");
        relativeLayout.setBackgroundColor(getContext().getColor(R.color.navyblue));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(600, 600);
        CurrebtWidth = 1000;
        CurrentHeight = 1000;
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        relativeLayout.setLayoutParams(layoutParams);
        editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        CurrentHeightofEditdtext = 200;
        imageParams = new RelativeLayout.LayoutParams(300, 300);
        CurrentHeightofImage = 300;
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        imageView.setLayoutParams(imageParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(R.drawable.ask_question_logo);
        imageView.setId(View.generateViewId());
        Log.d(TAG, "Height of image" + imageView.getHeight());
        relativeLayout.setId(View.generateViewId());
        Log.d(TAG, "ID of Rev" + relativeLayout.getId());
        editText.setLayoutParams(editTextParams);
        editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        editTextParams.setMargins(0, 0, 0, 10);
        editText.setGravity(Gravity.CENTER);
        editText.setId(View.generateViewId());
        editText.setLongClickable(false);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int totalTextHeight = editText.getLayout().getHeight();
                int visibleHeight = editText.getHeight();
                Log.d(TAG, "onTextChanged: " + totalTextHeight + "visble : Z" + visibleHeight);
                prevline = line;
                line = editText.getLineCount();

                if (isTextHidden(editText)) {
                    editText.setTextSize((float) (editText.getTextSize() * 0.2));
                }
                if (prevline != line) {
                    if (line > prevline) {
                        int height = imageParams.height;
                        imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) (imageView.getHeight() / 2));
                        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        imageView.setLayoutParams(imageParams);
                    } else {
                        if (imageView.getHeight() < CurrentHeightofImage) {
                            int height = imageParams.height;
                            imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) (imageView.getHeight() * 2));
                            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                            imageView.setLayoutParams(imageParams);
                        }
                    }
                }
                if (imageView.getHeight() < 40) {
                    editText.setTextSize((float) (editText.getTextSize() * 0.3));
                    imageParams = new RelativeLayout.LayoutParams(CurrentHeightofImage, CurrentHeightofImage);
                    imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    line = editText.getLineCount();
                    prevline = editText.getLineCount();
                    imageView.setLayoutParams(imageParams);
                    editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CurrentHeightofEditdtext);
                    editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
                    editTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    editText.setGravity(Gravity.CENTER);
                    editText.setLayoutParams(editTextParams);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        relativeLayout.addView(editText);
        relativeLayout.addView(imageView);
        relativeLayout.setLayoutParams(layoutParams);
        Log.d(TAG, "Layout is loaded");
    }
    private boolean isTextHidden(EditText editText) {
        int scrollY = editText.getScrollY() - 1;
        int totalTextHeight = editText.getLayout().getHeight() + 50;
        int visibleHeight = editText.getHeight();
        return scrollY >= 0 && totalTextHeight > visibleHeight;
    }

    public void showKeybard(EditText editText) {
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText, 1);
    }

    public void hideKeyboard(View view) {
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        view.clearFocus();
    }
}
